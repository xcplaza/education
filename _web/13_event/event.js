const input = document.querySelector('input');
const btn = document.querySelector('#btn3');
const a = document.querySelector('a');
const div = document.querySelector('.container');

document.body.onclick = function (e) {
    console.log('body');
}
div.onclick = function (e) {
    e.stopPropagation(); //запретить на боди ловить обработчик
    console.log('clicked by div')
    console.log(e.target);
    console.log(e.currentTarget);
}

a.onclick = function (event) {
    event.preventDefault();
    alert('Not today!');
}

function show() {
    console.log('click from JS');
}

// ===================================
btn.oncontextmenu = function (event) {
    event.preventDefault();
    input.value = '';
}

btn.onclick = show;
// OR + input value
btn.onclick = function () {
    console.log('click');
    console.log(input.value);
};

// OR + uppercase
btn.onclick = function (event) {
    let text = input.value;
    input.value = text.toUpperCase();
    console.log(event);
};
// ==================================
btn.addEventListener('click', show);
btn.addEventListener('click', function () {
    console.log('addEventListener2');
});

// =================================
input.onkeyup = function (event) {
    if (event.key === 'Enter') {
        console.log(input.value);
        console.log(event);
    }
};

input.oninput = function (e) {
    console.log(e.target);
    e.target.value = e.target.value.toUpperCase();
}

input.onblur = function (e) {
    alert(e.target.value);
}
