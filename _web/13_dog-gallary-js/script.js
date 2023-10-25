const detailsImage = document.querySelector('.details-image');
const detailsTitle = document.querySelector('.details-title');
const detailContainer = document.querySelector('.details-container');
const anchorElements = document.querySelectorAll('.thumbnails-anchor');
const main = document.querySelector('main');
const hiddenButton = document.querySelector('.hide-button');

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
}

function showDetails() {
    main.classList.remove('hidden');
}

function hideDetails() {
    main.classList.add('hidden');
}