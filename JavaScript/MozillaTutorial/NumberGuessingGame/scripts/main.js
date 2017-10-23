var randomNumber = Math.floor(Math.random() * 100) + 1;

var guessField = document.querySelector('.guessField');
var guessSubmit = document.querySelector('.guessSubmit');

var guesses = document.querySelector('.guesses');
var lastResult = document.querySelector('.lastResult');
var lowOrHi = document.querySelector('.lowOrHi');

var guessCount = 1;
var resetButton;

function checkGuess() {
    let userGuess = Number(guessField.value);
    fillLastResults(userGuess);
    console.log('lastResult = ' + lastResult.textContent);
    
    guessCount++;
}

function fillLastResults(userGuess) {
    if (guessCount === 1) {
        lastResult.textContent = 'Previous propositions :';
    }
    lastResult.textContent += ' ' + userGuess;
}

guessSubmit.addEventListener('click', checkGuess);
