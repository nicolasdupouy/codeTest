var http = require('http');
var url = require('url');

var server = http.createServer(function(request, response) {
	var page = url.parse(request.url).pathname;
	console.log(page);
	
	response.writeHead(200, {"Content-Type": "text/plain"});
	response.write('Bien le bonjour');
	response.end();
});
server.listen(8080);