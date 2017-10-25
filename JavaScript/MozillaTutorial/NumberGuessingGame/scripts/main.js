const MAX_GUEST_COUNT = 10;

var randomNumber;
setRandom();

var guessField = document.querySelector('.guessField');
var guessSubmit = document.querySelector('.guessSubmit');

var guesses = document.querySelector('.guesses');
var lastResult = document.querySelector('.lastResult');
var lowOrHi = document.querySelector('.lowOrHi');

var guessCount = 1;
var resetButton;

function setRandom() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    console.log(randomNumber);
}

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
    guessField.disabled = true;
    guessSubmit.disabled = true;
    
    resetButton = document.createElement('button');
    resetButton.textContent = 'Start new game';
    document.body.appendChild(resetButton);
    resetButton.addEventListener('click', resetGame);
}

function resetGame() {
    guessField.disabled = false;
    guessField.value = '';
    guessField.focus();
    
    guessSubmit.disabled = false;
    guessCount = 1;
    
    var resultParameters = document.querySelectorAll('.resultParas p');
    for(var i=0; i<resultParameters.length; i++) {
        resultParameters[i].textContent = '';
    }
    lastResult.style.backgroundColor = 'white';

    document.body.removeChild(resetButton);
    setRandom();
}

guessSubmit.addEventListener('click', checkGuess);
