var http = require('http');

/*var instructionNouveauVisiteur = function(req, res) {
	res.writeHead(200);
	res.end('Salut tout le monde !');
}
var server = http.createServer(instructionNouveauVisiteur);*/

var server = http.createServer(function(req, res) {
	res.writeHead(200);
	res.end('Salut tout le monde !');
});
server.listen(8080);