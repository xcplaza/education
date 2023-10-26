function sum(a, b) {
    return a + b;
}

console.log(sum(1, 2));

let add = function (a, b) {
    return a + b;
}
console.log(add(1, 2));

//  (arguments) => {body}   general formula
//  arg => {body}           if 1 argument
// (arg1, arg2) => {body}   if 2 arguments or more
// () => {body}             if no arguments

let sumArrow = (a, b) => {
    return a + b;
}

sumArrow = (a, b) => a + b;
console.log(sumArrow(1, 2));

let someFunc = something => {
    let temp = parseInt(something);
    temp *= 3;
    // return temp;
    console.log(temp);
}
someFunc('     1234dddd');

let display = () => console.log('Hello world');
display();

let array = [1, 2, 3, 4, 5, 6, 7]
console.log(array.filter(v => v % 2 === 0));

array.sort((v1, v2) => v2 - v1);
console.log(array);

//  return object
let build = name => {
    return {firstName: name};
}
console.log(build('masha'));
//   OR
let build1 = name => ({firstName: name});
console.log(build('pasha'));


let btnSimple = document.querySelector('#simple');
let btnArrow = document.querySelector('#arrow');

function simpleHandler() {
    console.log(this);
}

let ArrowHandler = () => {
    console.log(this);
}

btnSimple.onclick = simpleHandler;
btnArrow.onclick = ArrowHandler;


let person = {
    name: 'person',
    displayNameSimple: function () {
        console.log(this.name)
    },
    displayNameArrow: () => console.log(this.name)
};
person.displayNameSimple();
person.displayNameArrow();
