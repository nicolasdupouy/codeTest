import java.net.InetSocketAddress;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;

public class Program {

	private static final Logger logger = new Logger();

	public static void main(String[] args) throws Exception {
		Program program = new Program();

		EchoServer echoServer = program.new EchoServer();
		echoServer.launch(args);
	}

	public class EchoServer {

		private static final String USAGE = "Usage is: \"java -cp .:netty.jar Program port_number\"";
		private static final String ERROR_MISSING_PORT_NUMBER = "You must provide a port number.\n" + USAGE + "\n";
		private static final String ERROR_BAD_FORMAT_PORT_NUMBER = "You must provide a valid port number (number).\n"
				+ USAGE + "\n";
		private final int ALLOWED_CHARACTER_BUFFER_SIZE = 8192;

		private int portNumber;
		private ServerBootstrap bootstrap;

		public void launch(String[] args) {
			initializePortNumber(args);
			create();
			bind();
		}

		private void initializePortNumber(String[] args) {
			if (args == null || args.length == 0) {
				exitOnError(ERROR_MISSING_PORT_NUMBER);
			}
			try {
				portNumber = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				exitOnError(ERROR_BAD_FORMAT_PORT_NUMBER
						+ "\n" + "Given was: " + args[0]);
			}
		}

		private void create() {
			/* => [Half-Sync/Half-Async pattern]
			 * 
			 * Netty manages the pool of threads used for handling the multiple client connection requests.
			 * As Netty provides a high level of abstraction. We don't have much work to do.
			 * 
			 * We create 2 thread pools
			 * 1 - The Boss Threads: Threads provided by this pool are boss threads. Boss threads create and connect/bind sockets and then pass them off to the worker threads.
			 *                       It the synchronous part of the Half-Sync/Half-Async pattern.
			 * 2 - The Worker Threads: Worker threads perform all the asynchronous I/O
			 *                       It the asynchronous part of the Half-Sync/Half-Async pattern.
			 *                       
			 */
			ChannelFactory factory = new NioServerSocketChannelFactory(
					new OrderedMemoryAwareThreadPoolExecutor(4, 1048576, 1048576), //   Boss pool of threads
					new OrderedMemoryAwareThreadPoolExecutor(16, 1048576, 1048576)); // Worker pool of threads

			/* => [Reactor pattern]
			 * 
			 * It handles the requests made concurrently by multiples clients (connecting for exemple with "telnet localhost portNumber")
			 * This is the reason of the pools of threads initialized before.
			 */
			bootstrap = new ServerBootstrap(factory);
			bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
				public ChannelPipeline getPipeline() {
					ChannelPipeline pipeline = Channels.pipeline();
					pipeline.addLast("delimiter",
							new DelimiterBasedFrameDecoder(ALLOWED_CHARACTER_BUFFER_SIZE, Delimiters.lineDelimiter()));
					pipeline.addLast("decoder", new StringDecoder());
					pipeline.addLast("encoder", new StringEncoder());
					/* => [Acceptor-Connector pattern] - Connector part (connect to the handler)
					 * 
					 * This is the service handler who manages the incoming requests and dispatches them synchronously to the associated request handlers
					 * This part is the Connector part which dispatch to the request handler (which is here the "EchoServerHandler" class).
					 */
					pipeline.addLast("handler", new EchoServerHandler());

					return pipeline;
				}
			});

			bootstrap.setOption("child.tcpNoDelay", true);
			bootstrap.setOption("child.keepAlive", true);
		}

		private void bind() {
			/* => [Acceptor-Connector pattern] - Acceptor part
			 * 
			 * This is the service handler who manages the incoming requests and dispatches them synchronously to the associated request handlers
			 * This part is the Acceptor part who listen to and accept the incoming requests. The hand will then be given to the Connector part (see previous comment).
			 */
			Channel acceptor = bootstrap.bind(new InetSocketAddress(portNumber));

			if (!acceptor.isBound()) {
				exitOnError("Server :: Error! Unable to bind to port " + portNumber);
			}

			logger.info(
					"Server :: Successfully bound to port "
							+ portNumber + " !\n"
							+ "Awaiting new connections...");
		}

		private void exitOnError(String errorMessage) {
			logger.error(errorMessage);
			System.exit(-1);
		}
	}

	/*
	 * => [Wrapper Facade pattern]
	 * 
	 * This pattern is symbolized in Netty by the classes/mechanisms "ChannelBuffer", "Channel", "Channels", etc... 
	 * which manages the basic abstraction of the network. Hiding the underlying complexity.
	 * 
	 * It allows the developer to use a comfortable API (see the overrided methods below) instead of using directly 
	 * sockets and complex data structure relationships as explain in the course.
	 */
	public class EchoServerHandler extends SimpleChannelUpstreamHandler {

		private static final String HEADER_CLIENT_MESSAGE = "Hello client, I received your message saying: ";
		private static final String HEADER_SERVER_MESSAGE = "Server :: Received a new message from client";

		private void printMessageToClient(MessageEvent e) {
			e.getChannel().write(
					HEADER_CLIENT_MESSAGE
							+ e.getMessage()
							+ "\n");
		}

		private void printMessageToServer(MessageEvent e) {
			logger.info(HEADER_SERVER_MESSAGE
					+ " ["
					+ e.getChannel().getRemoteAddress() + "]\n"
					+ "=> " + e.getMessage());
		}

		@Override
		public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
			if (e instanceof ChannelStateEvent) {
				logger.info("Server :: Channel state changed: " + e);
			}
			super.handleUpstream(ctx, e);
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
			e.getCause().printStackTrace();
			logger.error("Server :: exception caught " + e);
			logger.error("Server :: Channel will be closed !");
			e.getChannel().close();
			super.exceptionCaught(ctx, e);
		}

		@Override
		public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
			printMessageToClient(e);
			printMessageToServer(e);
			super.messageReceived(ctx, e);
		}
	}

	private static class Logger {
		public void info(String message) {
			System.out.println(message);
		}

		public void error(String message) {
			System.err.println(message);
		}
	}
}
