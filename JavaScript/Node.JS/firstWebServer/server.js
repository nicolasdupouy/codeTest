let http = require('http');
let url = require('url');
let fs = require('fs');

// Event name
const EVENT_REQUEST = 'request';

// Response
const RESPONSE_CONTENT_TYPE_KEY = 'Content-Type';
const RESPONSE_CONTENT_TYPE_VALUE = 'text/html; charset=utf-8';

// HTTP codes
const HTTP_CODE_OK = 200;
const HTTP_CODE_NOT_FOUND = 404;

// File
const FILE_NAME = 'index.html';
const FILE_NOT_FOUND = "This file doesn't exists";

// Log messages
const LOG_MESSAGE_REQUEST_RECEIVED = "request received";


let server = http.createServer();
server.on(EVENT_REQUEST, (request, response) => {
    console.log(LOG_MESSAGE_REQUEST_RECEIVED);
    fs.readFile(FILE_NAME, 'utf8', (err, data) => {
        if (err) {
            setResponseHeadNotFound(response);
        }

        let name = getNameFromQueryParams(request);
        data = data.replace('{{name}}', name);
        setResponseHeadOk(response, data);
    });
});
server.listen(8080);

function getNameFromQueryParams(request) {
    let queryParameters = url.parse(request.url, true).query;
    let name = queryParameters.name === undefined ? "anonymous" : queryParameters.name;
    return name;
}

function setResponseHeadNotFound(response) {
    response.writeHead(HTTP_CODE_NOT_FOUND);
    response.write(FILE_NOT_FOUND);
    response.end();
}

function setResponseHeadOk(response, data) {
    response.writeHead(HTTP_CODE_OK, {RESPONSE_CONTENT_TYPE_KEY: RESPONSE_CONTENT_TYPE_VALUE});
    response.end(data);
    response.end();
}