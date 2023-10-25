const detailsImage = document.querySelector('.details-image');
const detailsTitle = document.querySelector('.details-title');
const detailContainer = document.querySelector('.details-container');
const anchorElements = document.querySelectorAll('.thumbnails-anchor');
const main = document.querySelector('main');
const hiddenButton = document.querySelector('.hide-button');
const audio = document.querySelector('audio');

for (let a of anchorElements) {
    a.onclick = function () {
        setDetails(a);
    }
}

hiddenButton.onclick = function () {
    hideDetails();
}

function setDetails(a) {
    detailsImage.src = a.getAttribute('data-details-image');
    detailsTitle.innerHTML = a.getAttribute('data-details-title');
    showDetails();
    audio.src = a.getAttribute('data-details-audio');
    audio.play();
    setTimeout(function () {
        audio.pause();
    }, 2000)
}

function showDetails() {
    main.classList.remove('hidden');
    detailContainer.classList.add('is-dot');
    setTimeout(function () {
        detailContainer.classList.remove('is-dot');
    }, 500);

}

function hideDetails() {
    main.classList.add('hidden');
}