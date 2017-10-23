const LOGO_FIREFOX = 'images/firefox-icon.png';
const LOGO_FREEBSD = 'images/FreeBSD-icon.png';
const LOCALSTORAGE_USERNAME = 'userName';

let title = document.querySelector('h1');
let button = document.querySelector('button');

function initUserName() {
    if (!localStorage.getItem(LOCALSTORAGE_USERNAME)) {
        promptForUser();
    }
}

function promptForUser() {
    let userName = prompt('Please enter your name.');
    localStorage.setItem(LOCALSTORAGE_USERNAME, userName);
}

function displayTitle() {
    let registeredName = localStorage.getItem(LOCALSTORAGE_USERNAME);
    title.textContent = title.textContent = 'Hello ' + registeredName;
}

function switchImage() {
    let image = document.querySelector('img');
    image.onclick = function() {
        let imageSource = image.getAttribute('src');
        if (imageSource === LOGO_FIREFOX) {
            image.setAttribute('src', LOGO_FREEBSD);
        }
        else {
            image.setAttribute('src', LOGO_FIREFOX);
        }
    }
}

initUserName();
displayTitle();
switchImage();
button.onclick = function() {
    promptForUser();
    displayTitle();
}