function sum(x, y) {
    console.log(x + y);
}

let add = sum;
add(1, 2);

let div = function (x, y) {
    console.log(x / y);
}
div(20, 10);

function choice(f1, f2, x, y) {
    console.log(arguments);
    if (y === undefined) {
        return f2(x);
    } else {
        return f1(x, y);
    }
}

function mul(x, y) {
    return x * y;
}

function power2(x) {
    return 2 ** x;
}

console.log(choice(mul, power2, 10));
console.log(choice(mul, power2, 10, 2));

function first() {
    return function () {
        console.log("I'm second");
    }
}

let res = first();
console.log(res);
res();
console.log(res());

console.log('auto function (IIFE) ========================');
(function (name) {
    console.log('Hello ' + name)
})('JS')