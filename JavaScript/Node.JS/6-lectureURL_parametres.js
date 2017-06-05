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

	// http://localhost:8080/page/modules/admin/nicolas?firstName=Nicolas&lastName=Dupouy&user=ndu&pass=passwd
	
	response.writeHead(200, {"Content-Type": "text/plain"});
	if ('firstName' in params && 'lastName' in params) {
		response.write('Your name is ' + params['firstName'] + ' ' + params['lastName']);
	}
	else {
		response.write('Your first name and/or last name are missing !');
	}
	response.end();
});
server.listen(8080);