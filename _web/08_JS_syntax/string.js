let str = 'Hello world';
console.log(str.length);
console.log(str.toUpperCase());
console.log(str.toLowerCase());
console.log(str.charAt(0));
console.log(str.indexOf('world'));
console.log(str.lastIndexOf('world'));



console.log(str.includes('wor'));
console.log(str.startsWith('w'));
console.log(str.endsWith('w'));

console.log(str.substring(4, 9));
console.log(str.substring(9, 4));
console.log(str.substring(4));

console.log(str.substr(4));
console.log(str.substr(4, 3));
console.log(str.substr(-4));
console.log(str.substr(-4, 3));

console.log(str.slice(0));
console.log(str.slice(0, 5));

str = '    Hello world     ';
console.log(str.trim());
console.log(str.trimStart());
console.log(str.trimEnd());

console.log(str.split(' '));

console.log(str.repeat(5));

console.log(str.replace('world', 'JavaScript'));
console.log(str.replaceAll('l', 'L'));

str = 'Hello world';
console.log(str.codePointAt(3));