function greeting() {
    console.log('Hello');
}

greeting();
console.log(greeting());

function getnumber() {
    return 10;
}

console.log(getnumber())

function sayHello(name) {
    console.log(`Hello ${name}`)
}

sayHello('Masha');

function sum(x, y) {
    return x + y;
}

let res = sum(1, 2);
console.log(res);

console.log(sum());  //NaN
console.log(sum(1));  //NaN
console.log(sum(1, 2, 3));
