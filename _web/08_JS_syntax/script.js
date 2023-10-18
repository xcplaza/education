let bool;
if (bool) {
    console.log("true");
} else {
    console.log("false");
}

console.log(10 ** 3);

// logic operators
let res = 0 || '' || undefined || {} || undefined;
console.log(res);
res = 0 || '' || undefined || null || undefined;
console.log(res);

res = 0 && '' && undefined && null && undefined;
console.log(res);

//  default values
console.log('1 solution ========================');

function some(num) {
    console.log(num);
}


function some(num) {
    // if (!num && num != 0)
    if (!num && typeof num != "number") {
        num = 100;
    }
    console.log(num);
}

some();
some(1);
some(0)
console.log('2 solution ========================');

function some(num) {
    let ref = num || 100    // null OR undefined OR '' OR  0  OR false
    console.log(ref);
}

some();
some(1);
some(0)

console.log('3 solution ========================');

function some(num = 100, num1 = 20) {
    console.log(num);
}

some();
some(1);
some(0)

console.log('4 solution ========================');

function some(num) {
    let res = num ?? 100;   // null OR undefined
    console.log(res);
}

some();
some(1);
some(0);

console.log('========================');
console.log(3 == 3)
console.log(3 === 3)

console.log('3' == 3)
console.log('3' === 3);
console.log((5 - 2) === 3);

console.log(undefined == null)
console.log(undefined == NaN)
console.log(NaN == NaN)

console.log('========================');