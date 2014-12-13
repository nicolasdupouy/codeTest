var http = require('http');

/*var server = http.createServer(function(request, response) {
	response.writeHead(200);
	response.write('Salut tout le monde');
});*/
var server = http.createServer();
server.on('request', function(request, response) {
	console.log('[Requête reçue]');
	response.writeHead(200);
	response.write('Salut tout le monde');
});

server.on('close', function() {
	console.log('Bye bye !');
});

server.listen(8080);
//server.close();