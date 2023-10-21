let array = [1,2,3,4];
array.forEach(function (item)
{
    console.log(item);
})

let res = array.map(function (item)
{
    return item*2;
});
console.log(res);

res = array.map(function (item)
{
    return `<li>${item}</li>`;
});
console.log(res);
console.log(res.join(""));

let sum = array.reduce(function (accum, item) //acum=10 item=4
{
    return accum + item;
});
console.log(sum);

sum = array.reduce(function (accum, item)//1it accum=10 item=4
{
    return accum + item;
}, 0);
console.log(sum);
//let array = [1,2,3,4];

let max = array.reduce(function (accum, item)
{
    // return accum < item ? item : accum;
    return Math.max(accum, item);
});
console.log(max);

max = Math.max(...array);
console.log(max);

max = array.reduceRight(function (accum, item)
{
    return Math.max(accum, item);
});
console.log(max);

array = [[1,2,3], [4,5,6], [7,8,9]];//-> [1,2,3,4,5,6,7,8,9]
console.log(array.reduce(function (accum, item)
{
    return accum.concat(item);
}))

console.log(array.reduceRight(function (accum, item)
{
    return accum.concat(item);
}))