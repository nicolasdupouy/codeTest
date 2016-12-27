var http = require('http');
var url = require('url');
var queryString = require('querystring');

var server = http.createServer(function(request, response) {
	var page = url.parse(request.url).pathname;
	var query = url.parse(request.url).query;
	var params = queryString.parse(query);
	
	// http://localhost:8080/page/modules/admin/nicolas?user=ndu&pass=blablabla
	console.log('page = ' + page); 		// page = /page/modules/admin/nicolas
	console.log('query = ' + query);	// user=ndu&pass=blablabla
	console.log('params = ' + params);	// params = [object Object]
	
	response.writeHead(200, {"Content-Type": "text/plain"});
	if ('prenom' in params && 'nom' in params) {
		response.write('Vous vous appelez ' + params['prenom'] + ' ' + params['nom']);
	}
	else {
		response.write('Prénom et Nom manquants !');
	}
	response.end();
});
server.listen(8080);