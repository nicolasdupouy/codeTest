var http = require('http');
var url = require('url');

var server = http.createServer(function(request, response) {
	var page = url.parse(request.url).pathname;
	console.log(page);
	
	response.writeHead(200, {"Content-Type": "text/plain"});
	if (page == '/') {
        response.write('Vous êtes à l\'accueil, que puis-je pour vous ?');
    }
    else if (page == '/sous-sol') {
        response.write('Vous êtes dans la cave à vins, ces bouteilles sont à moi !');
    }
    else if (page == '/etage/1/chambre') {
        response.write('Hé ho, c\'est privé ici !');
    }
	else {
		response.writeHead(404, {"Content-Type": "text/plain"});
		response.write('page inconnue');
	}
	response.end();
});
server.listen(8080);