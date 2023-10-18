let date = new Date();
console.log(date);

date = new Date(1_000_000_000);
console.log(date);

date = new Date('2023-11-01');
console.log(date);

date = new Date(2022, 10, 1);
console.log(date);

date = new Date();
console.log(`day ${date.getDate()}
month ${date.getMonth()}
full year ${date.getFullYear()}
time: ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}
day of week ${date.getDay()}
time offset: ${date.getTimezoneOffset()}
`);

console.log(date.toString());
console.log(date.toDateString());
console.log(date.toTimeString());
console.log(date.toISOString());

// date.LocalString(Local, options);
// date.LocalDateString(Local, options);
// date.LocalTimeString(Local, options);