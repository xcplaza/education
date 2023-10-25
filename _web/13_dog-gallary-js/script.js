const detailsImage = document.querySelector('.details-image');
const detailsTitle = document.querySelector('.details-title');
const detailContainer = document.querySelector('.details-container');
const anchorElements = document.querySelectorAll('.thumbnails-anchor');

for (let a of anchorElements) {
    a.onclick = function () {
        setDetails(a);

    }
}

function setDetails(a) {
    detailsImage.src = a.getAttribute('data-details-image');
    detailsTitle.innerHTML = a.getAttribute('data-details-title');
}