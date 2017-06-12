let http = require('http');
let fs = require('fs');

let server = http.createServer();
server.on('request', (request, response) => {
    console.log("request received");
    fs.readFile('index.html', (err, data) => {
        if (err) {
            setResponseHeadNotFound(response);
        }
        setResponseHeadOk(response, data);
    });
});
server.listen(8080);


function setResponseHeadNotFound(response) {
    response.writeHead(404);
    response.write("This file doesn't exists");
    response.end();
}

function setResponseHeadOk(response, data) {
    response.writeHead(
        200, 
        {'Content-Type': 'text/html; charset=utf-8'});
    response.end(data)
}