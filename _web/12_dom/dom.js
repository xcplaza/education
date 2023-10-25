// old school method
// const div1 = document.getElementById('div1');
// const p1 = document.getElementsByClassName('p1');
// const p = document.getElementsByTagName('p');

const div1 = document.querySelector('#div1');
const p1 = document.querySelector('.p1');
const p = document.querySelector('p');
const pAll = document.querySelectorAll('p');
// const pDiv = document.querySelectorAll('div p');
const pDiv = div1.querySelectorAll('p');

const pOuter = document.querySelector('#outer');

console.log(p)
console.log(pAll);
console.log(div1);
console.log(pDiv);

div1.style.border = '1px solid green';
for (let i = 0; i < pDiv.length; i++) {
    console.log(pDiv[i].innerHTML);
    pDiv[i].innerHTML += `<span> new text ${i + 1}</span>`;
}

console.log(pOuter.className);
pOuter.className = 'header';
console.log(pOuter.className);
pOuter.className += ' active';
console.log(pOuter.className);

console.log(pOuter.classList);
pOuter.classList.toggle('active'); //delete active if to be
// pOuter.classList.toggle('active'); //add active if to be

// timestamp
setTimeout(function () {
    pOuter.classList.add('active');
}, 2000);
setTimeout(function () {
    pOuter.classList.remove('active');
}, 4000);

// box animation
const container = document.querySelector('#container');
const box = document.querySelector('#box');

// let pos = 0;
// let end = setInterval(function () {
//     pos++;
//     // if (pos >= 151) {
//     if (pos >= container.offsetWidth - box.offsetWidth) {
//         clearInterval(end);
//         box.style.right = pos + 'px';
//     }
//     box.style.left = pos + 'px';
//     // box.style.top = pos + 'px';
// }, 30);

const size = container.offsetWidth - box.offsetWidth;
let pos = 1;
let step = 1;
box.style.top = 0 + 'px';
setInterval(function () {
    box.style.left = pos + 'px';
    pos += step;
    if (pos >= size)
        step = -1;
    else if (pos <= 0)
        step = 1;
})

//  another parrameters for animation
// container.style.width = '250px';
// container.style.height = '150px';

// DOM elements
const children = div1.children;
console.log(children);
div1.firstElementChild.style.color = 'red';
div1.lastElementChild.style.color = 'blue';
div1.lastElementChild.previousElementSibling.style.color = 'green';
console.log(div1.lastElementChild);
console.log(div1.lastChild);
div1.lastChild.textContent = `I am last text`;