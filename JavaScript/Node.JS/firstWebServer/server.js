let http = require('http');
let fs = require('fs');

let server = http.createServer();
server.on('request', (request, response) => {
    console.log("request received");
    fs.readFile('/Users/nicolasdupouy/gitRepos/codeTest/JavaScript/Node.JS/firstWebServer/index.html', (err, data) => {
        if (err) {
            response.writeHead(404);
            response.end("This file doesn't exists");
        }
        response.writeHead(200, {
            'Content-Type': 'text/html; charset=utf-8'
        });
        response.end(data);
    });
});
server.listen(8080);