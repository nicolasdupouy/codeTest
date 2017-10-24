const MAX_GUEST_COUNT = 10;

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
    fillGuesses(userGuess);
    
    if (userGuess === randomNumber) {
        lastResult.textContent = 'Congratulations! You got it right!';
        lastResult.style.background = 'green';
        lowOrHi.textContent = '';
        finishGame();
    }
    else if (guessCount === MAX_GUEST_COUNT) {
        lastResult.textContent = '!!!GAME OVER!!!';
        lastResult.style.backgroundColor = 'red';
        finishGame();
    }
    else {
        lastResult.textContent = 'Wrong guess';
        lastResult.style.backgroundColor = 'red';
        if (userGuess > randomNumber) {
            lowOrHi.textContent = 'Last guess was too high !';
        }
        else {
            lowOrHi.textContent = 'Last guess was too low !';
        }
        guessCount++;
    }
    
    guessField.value = '';
    guessField.focus();
}

function fillGuesses(userGuess) {
    if (guessCount === 1) {
        guesses.textContent = 'Previous propositions :';
    }
    guesses.textContent += ' ' + userGuess;
}

function finishGame() {
    
}

guessSubmit.addEventListener('click', checkGuess);
