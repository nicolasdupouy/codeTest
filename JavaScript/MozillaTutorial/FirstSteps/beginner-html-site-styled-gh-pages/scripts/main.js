const LOGO_FIREFOX = 'images/firefox-icon.png';
const LOGO_FREEBSD = 'images/FreeBSD-icon.png';

let title = document.querySelector('h1');
let image = document.querySelector('img');

function changeTitle() {
    title.textContent = 'Hello Friend !';
}

function switchImage() {
    let imageSource = image.getAttribute('src');
    
    if (imageSource === LOGO_FIREFOX) {
        image.setAttribute('src', LOGO_FREEBSD);
    }
    else {
        image.setAttribute('src', LOGO_FIREFOX);
    }
}

changeTitle();
image.addEventListener('click', switchImage);