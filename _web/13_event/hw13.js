// solution 1
// const btn1 = document.querySelector('#btn1');
// const btn2 = document.querySelector('#btn2');
// const btn3 = document.querySelector('#btn3');
// const green = document.querySelector('#green');
// const red = document.querySelector('#red');
// const blue = document.querySelector('#blue');
// solution 2
const p = document.querySelector('p');
const wrapper = document.querySelector('#wrapper');

// solution 1
// btn1.onclick = function () {
//     p.style.fontSize = '15px';
// }
// btn2.onclick = function () {
//     p.style.fontSize = '25px';
// }
// btn3.onclick = function () {
//     p.style.fontSize = '35px';
// }
//
// green.onclick = function () {
//     p.style.color = 'green';
// }
// red.onclick = function () {
//     p.style.color = 'red';
// }
//
// blue.onclick = function () {
//     p.style.color = 'blue';
// }

// solution 2
wrapper.onclick = function (e) {
    if (e.target.className === 'size')
        p.style.fontSize = e.target.innerText;
    else if (e.target.className === 'color')
        p.style.color = e.target.innerText;
}

// --- task 2 -----
const inSize = document.querySelector('#inSize');
const inColor = document.querySelector('#inColor');
const setSize = document.querySelector('#setSize');
const setColor = document.querySelector('#setColor');
const p2 = document.querySelector('#p2');

setSize.onclick = function () {
    p2.style.fontSize = inSize.value + 'px';
}
setColor.onclick = function () {
    p2.style.color = inColor.value.trim().toLowerCase();
}

//  solution 2
function updateText(){
    p2.style = `font-size: ${inSize.value}px; color: ${inColor.value}`;
}

setColor.oninput = updateText;
setSize.oninput = updateText;