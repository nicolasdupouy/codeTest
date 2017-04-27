let http = require('http');
let fs = require('fs')

let server = http.createServer();
server.on('request', (request, response) => {
    console.log("request received");
    response.writeHead(200, {
        'Content-Type': 'text/html; charset=utf-8'
    });
    response.end("<strong>Hello</strong> and welcome on the server");
});
server.listen(8080);