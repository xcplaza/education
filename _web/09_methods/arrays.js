let array = ['hello', 123, true, 1.1, undefined, {}];
console.log(array);
console.log(array[3]);

for (let v of array)
{
    console.log(v);
}
array[4] = 100500;
console.log(array);
console.log(array.length);

array[100000] = 'bye';
console.log(array.length);
console.log(array[500]);
console.log(array);
// {0: 'hello', 1: 123, 2: true, 3: , 4: , 5: {}, 100000: 'bye'}
array[-10] = 1000;
array['hello'] = 1000;
console.log(array);


//1
array = [];
//2
array = [1,2,3,4];
//3
array = new Array(10);
array.fill(false);
console.log(array);
array.fill(true, 3, 6);
console.log(array);
//4
array = Array.of(1,2,3,4,5,6);
console.log(array);
//5
let str = 'hello world';
array = Array.from(str);
console.log(array);
console.log(array.length);

array.length = 7;
console.log(array);
console.log(array.length);

array.length = 20;
console.log(array);
console.log(array.length);

for(let k in array)
{
    // console.log(key);
    console.log(array[k]);
}
for (let v of array)
{
    console.log(v);
}

console.log('Hello'[3]);