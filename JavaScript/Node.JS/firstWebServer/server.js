let http = require('http');
let fs = require('fs');

let server = http.createServer();
server.on('request', (request, response) => {
    console.log("request received");
    fs.readFile('index.html', (err, data) => {
        if (err) {
            response.writeHead(404);
            response.end("This file doesn't exists");
        }
        setResponseHeadOk(response, data);
    });
});
server.listen(8080);

function setResponseHeadOk(response, data) {
    response.writeHead(
        200, 
        {'Content-Type': 'text/html; charset=utf-8'});
    response.end(data)
}