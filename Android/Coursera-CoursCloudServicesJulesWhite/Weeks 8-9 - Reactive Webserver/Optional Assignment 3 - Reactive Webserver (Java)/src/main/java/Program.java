import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

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
import org.jboss.netty.util.CharsetUtil;

public class Program {

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
				System.err.println(ERROR_MISSING_PORT_NUMBER);
				System.exit(-1);
			}
			try {
				portNumber = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println(ERROR_BAD_FORMAT_PORT_NUMBER);
				System.err.println("Given was: " + args[0]);
				System.exit(-1);
			}
		}

		private void create() {
			ChannelFactory factory = new NioServerSocketChannelFactory(
					Executors.newCachedThreadPool(),
					Executors.newCachedThreadPool());

			/*
			 * => [Reactor pattern]
			 * 
			 * It handles the requests made concurrently by multiples clients (connecting for exemple with "telnet localhost portNumber")
			 * This is the reason of the pools of threads initialized before.
			 */
			bootstrap = new ServerBootstrap(factory);
			bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
				public ChannelPipeline getPipeline() {
					return Channels.pipeline(
							new StringDecoder(CharsetUtil.UTF_8),
							new StringEncoder(CharsetUtil.UTF_8),
							/*
							 * For information, the "Delimiters.lineDelimiter()" handles the ["chunk" at a time or (b) a "line" at a time] as professor Schmidt asked.
							 * ==> http://docs.jboss.org/netty/3.2/api/org/jboss/netty/handler/codec/frame/Delimiters.html
							 */
							new DelimiterBasedFrameDecoder(ALLOWED_CHARACTER_BUFFER_SIZE, Delimiters.lineDelimiter()),
							/*
							 * => [Acceptor-Connector pattern] - Connector part (connect to the handler)
							 * 
							 * This is the service handler who manages the incoming requests and dispatches them synchronously to the associated request handlers
							 * 
							 * This part is the Connector part which dispatch to the request handler (which is here the "EchoServerHandler" class).
							 */
							new EchoServerHandler());
				}
			});

			bootstrap.setOption("child.tcpNoDelay", true);
			bootstrap.setOption("child.keepAlive", true);
		}

		private void bind() {
			/*
			 * => [Acceptor-Connector pattern] - Acceptor part
			 * 
			 * This is the service handler who manages the incoming requests and dispatches them synchronously to the associated request handlers
			 * 
			 * This part is the Acceptor part who listen to and accept the incoming requests. The hand will then be given to the Connector part (see previous comment).
			 */
			Channel acceptor = bootstrap.bind(new InetSocketAddress(portNumber));

			if (!acceptor.isBound()) {
				System.err.println("Server :: Error! Unable to bind to port " + portNumber);
				System.exit(-1);
			}

			System.out.println(
					"Server :: Successfully bound to port "
							+ portNumber + " !\n"
							+ "Awaiting new connections...");
		}
	}

	/*
	 * => [Wrapper Facade pattern]
	 * 
	 * It allows the developer to use a comfortable API (see the overrided methods below) instead of using directly 
	 * sockets and complex data structure relationships as explain in the course.
	 * In another words, it hides the complexity of the reality.
	 */
	public class EchoServerHandler extends SimpleChannelUpstreamHandler {

		private static final String HEADER_CLIENT_MESSAGE = "Hello client, I received your message saying: ";
		private static final String HEADER_SERVER_MESSAGE = "Server :: Received a new message from client";

		private void printMessageToClient(MessageEvent e) {
			e.getChannel().write(HEADER_CLIENT_MESSAGE
					+ e.getMessage());
		}

		private void printMessageToServer(MessageEvent e) {
			System.out.println(HEADER_SERVER_MESSAGE
					+ " ["
					+ e.getChannel().getRemoteAddress() + "]\n"
					+ "=> " + e.getMessage());
		}

		@Override
		public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
			if (e instanceof ChannelStateEvent) {
				System.out.println("Server :: Channel state changed: " + e);
			}
			super.handleUpstream(ctx, e);
		}

		@Override
		public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
			e.getCause().printStackTrace();
			System.err.println("Server :: exception caught " + e);
			System.err.println("Server :: Channel will be closed !");
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
}
