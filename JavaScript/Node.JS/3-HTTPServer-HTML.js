var http = require('http');

var server = http.createServer(function(request, response) {
	response.writeHead(200, {"Content-Type": "text/html"});
	response.end('<p>Voici un paragraphe <strong>HTML</strong></p>');
});
server.listen(8080);