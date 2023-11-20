let array = [1, 2, 3];
let array1 = ['one', 'two', 'three'];
let array2 = [1, 'hello', true];

const reverseArray = <T>(array: T[]): T[] => array.reverse();
console.log(reverseArray<number>(array));
console.log(reverseArray<string>(array1));
// console.log(reverseArray<number | string>(array2)); //Error