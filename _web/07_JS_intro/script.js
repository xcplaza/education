// alert('Hello from js file')
console.log('Hello world!');
console.log("Hello world!");
console.log(`Guests:
    * Masha
    * Pasha
    * Sasha`)

let x = 'Hello';
let y = 'Java Script';
console.log(x + ' today I\'m learn ' + y);
console.log(`${x} today I\'m learn ${y} and ${2 + 5 - 4 * 10}`)

var aa;
aa = 10;
console.log(aa);
var bb = 'Hello';
console.log(bb);
let c;
c = true;
console.log(c);
let d = [];
console.log(d);
const e = {};
console.log(e);

c = false;
aa = 1;
// e = 1; - constant don't reinitilaze!

for (let i = 0; i < 10; i++) {
    let res = i++;
}
// console.log(res);

temp = 10;
// let temp;
console.log(temp)

// undefined
let cx;
console.log(cx)

let variable;
variable = 10;
console.log(typeof variable);
variable = 'Hello';
console.log(typeof variable);
variable = true;
console.log(typeof variable);
variable = [];
console.log(typeof variable);
variable = {};
console.log(typeof variable);

console.log(typeof null);
console.log(typeof undefined);
console.log(typeof fn)
console.log(typeof (typeof 10));

function fn() {
}

// implicit coercion
console.log('3' + 3);
console.log('3' - 3);
let num = '1234'
console.log(typeof -num)
num = '1234'
console.log(+num);
console.log(typeof (!!num));
num = 1234
console.log(typeof (num + ''));
num = true;
console.log(typeof (num + ''));
console.log(typeof (+num));

//  +variable -> typeOf variable = number
//  !!variable -> typeOf variable = boolean
//  variable + '' -> typeOf variable = string

// explicit coercion
console.log('=======================')
console.log(typeof String(123));
console.log(typeof String(true));
console.log(typeof Number('123'));
console.log(typeof Boolean('123'));
console.log(typeof Number(true));

console.log('=======================')
console.log(`I am programmer`);
console.log("Hello");
console.log('i')
console.log('am')
console.log(`Elik`)

console.log('=======================')
console.log('b' + "a" + NaN + `a`);
console.log('b' + 'a' + +'b' + 'a');
console.log(`
bbb     a    b    b     a     b    b     a      
b  b  a   a  b b  b   a   a   b b  b   a   a  
bbb   aaaaa  b  b b   aaaaa   b  b b   aaaaa  
b  b  a   a  b   bb   a   a   b   bb   a   a  
bbb   a   a  b    b   a   a   b    b   a   a  
`);