let d = 255;    // decimal
let b = 0b11111111;   // binary
let o = 0o377;   // octal
let h = 0xff;    // hexadecimal

console.log(d);
console.log(b);
console.log(o);
console.log(h);

console.log(d.toString());
console.log(b.toString(2));
console.log(o.toString(8));
console.log(h.toString(16));

d = 1.567;
console.log(d.toExponential(2));
console.log(d.toFixed(2));
console.log(d.toPrecision(2));
console.log(d.valueOf())    // don't use!!!

// casting to number
console.log('casting =============================');
console.log(typeof +true);
console.log(typeof +'111')

// 2
console.log('2 =============================');
console.log(Number(true));
console.log(Number('111'));
console.log(Number('1.23'));
console.log(Number(null));
console.log(Number(undefined));
console.log(Number(NaN));
console.log(Number(new Date()));
console.log(Number('1,23'));
console.log(Number('1 2 3'));
console.log(Number('1-23'));
console.log(Number('123 '));
console.log(Number(' 123 '));
console.log(Number(' 123'));

// 3
console.log('3 =============================');
console.log(parseInt('111'));
console.log(parseInt('1.11'));
console.log(parseInt(' 111'));
console.log(parseInt('111 '));
console.log(parseInt(' 111 '));
console.log(parseInt('1 1 1'));
console.log(parseInt('111 text'));
console.log(parseInt(' text 111'));
console.log(parseInt('11,1'));

//4
console.log('4 =============================');
console.log(parseFloat('11.1'));

console.log(' =============================');
console.log(Number.isInteger(10));
console.log(Number.isInteger(10.6));
console.log(Number.isNaN(NaN));
console.log(Number.isFinite(0));
console.log(Number.isFinite(-0));
console.log(Number.isFinite(Number.POSITIVE_INFINITY));
console.log(Number.isFinite(Number.NEGATIVE_INFINITY));
console.log(Number.MAX_VALUE);
console.log(Number.MIN_VALUE);

console.log(' Math =============================');
d = 1.567;
console.log(Math.round(d));
console.log(Math.ceil(d));
console.log(Math.floor(d));
console.log(Math.trunc(d));
d = -1.567;
console.log(Math.round(d));
console.log(Math.ceil(d));
console.log(Math.floor(d));
console.log(Math.trunc(d));

console.log(Math.max(1, 5, -100, 30));
console.log(Math.min(1, 5, -100, 30));
console.log(Math.pow(10, 3));
console.log(Math.random());

let min = 10;
let max = 50;
console.log(Math.round(Math.random() * (max - min + 1) + min));

console.log(Math.abs(-1.23));
console.log(Math.abs(1.23));