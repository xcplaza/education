let array = [1, 2, 3, 4];
array.forEach(function (item) {
    console.log(item);
})

array.forEach(function (item) {
    item *= 2;
    console.log(item);
})

let res = array.map(function (item) {
    return item * 2;
});
console.log(res);

res = array.map(function (item) {
    return `<li>${item}</li>`;
});
console.log(res);
console.log(res.join(""));

let sum = array.reduce(function (accum, item) {
    return accum + item; // accum = 1  item = 2 => 3 etc.
});
console.log(sum);

sum = array.reduce(function (accum, item) {
    return accum + item;
}, 0);
console.log(sum);

let max = array.reduce(function (accum, item) {
    // return accum < item ? item : accum;
    return Math.max(accum, item);
});
console.log(max);

max = Math.max(...array);
console.log(max);

max = array.reduceRight(function (accum, item) {
    // return accum < item ? item : accum;
    return Math.max(accum, item);
});
console.log(max);

array = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];
console.log(array.reduce(function (ac, item) {
    return ac.concat(item);
}))

console.log(array.reduceRight(function (ac, item) {
    return ac.concat(item);
}))