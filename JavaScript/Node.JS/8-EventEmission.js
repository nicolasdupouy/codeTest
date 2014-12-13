var EventEmitter = require('events').EventEmitter;

var jeu = new EventEmitter();

jeu.on('newPlayer', function(name, lifePoints) {
	console.log('New player in game: ' + name + '[' + lifePoints + ']');
});

jeu.on('gameover', function(message) {
	console.log(message);
});

jeu.emit('newPlayer', 'Mario', 35);
jeu.emit('gameover', 'You win !');