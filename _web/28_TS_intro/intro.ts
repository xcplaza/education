let isLoading: boolean = true;
// isLoading = 1; // Error
let str: string = 'hello';
let num: number = 10;

console.log(isLoading);
console.log(str);
console.log(num);

let array: number[] = [1, 2, 3, 4];
let array1: Array<number> = [1, 2, 3, 4];
// array.push('hello'); // Error

// tuple
let person: [number, string, boolean] = [1, 'masha', true];
// person[0] = 'hello'; // Error
person.push('hello'); // Ok
console.log(person);

//any
let notSure: any = 4;
notSure = 'maybe a string instead';

function greeting(name: string): void{
    console.log('Hello, ' + name);
}