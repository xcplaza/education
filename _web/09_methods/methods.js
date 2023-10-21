let array = [1,2,3,10,11,12];
console.log(array.length)

//add
console.log(array.push(32,44));
console.log(array);

let array1 = [90, 91];
array.push(...array1);
console.log(array);

console.log(array.unshift(-1, 1000));
console.log(array);

console.log(array.splice(5, 0, 50, 60, 70));
// console.log(array.splice(5, 2));
// console.log(array.splice(5, 3, 50, 60, 70));
console.log(array);

//spread operator (...)
let array2 = array;
array2[0] = 20;
console.log(array);

let array3 = [...array];
array3[0] = -100;
console.log(array);

//remove
console.log(array.pop());
console.log(array.shift());
console.log(array.splice(5, 2));
array.splice(5, 100);
console.log(array);

let array4 = array.slice(1, 4);
console.log(array4);
array4[1] = 100;
console.log(array);

array4 = array.concat(array1, array3, 1, 2);
console.log(array4);

//search
console.log(array4.indexOf(1));
console.log(array4.lastIndexOf(1));
console.log(array4.indexOf(1, 5));
console.log(array4.lastIndexOf(1, 5));
console.log(array4.indexOf(-1));
console.log(array4.lastIndexOf(-1));

console.log(array4.includes(1000));
console.log(array4.includes(-1));
console.log(array4.includes(1000, 20));

array4.reverse();
console.log(array4);

let str = array4.join(" ");
console.log(str);