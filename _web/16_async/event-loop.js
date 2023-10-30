let count = 1;

// asynchronous code
let interval = setInterval(() => console.log(count++), 1000);
setInterval(() => {
    console.log('Time out');
    clearInterval(interval);
}, 3000);
// test();
console.log('end of code');

//  synchronous code
function test() {
    for (let i = 0; i < 10; i++) {
        console.log(i);
    }
}