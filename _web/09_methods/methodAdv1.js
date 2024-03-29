let array = [10, 11, 3, 56, 7, -812, 11, 56];
array.sort();
console.log(array);

array.sort(function (a, b)
{
    return a - b;
});
console.log(array);

array.sort(function (a, b)
{
    return b - a;
});
console.log(array);

array.splice(3, 0, true, 'abc');
array.sort(function (a, b)
{
    return a - b;
});
console.log(array);

array = ['Anna', 'Boris', 'Anton', 'Sasha', 'Angelika'];
array.sort();
console.log(array);

array.sort(function (a, b)
{
    if(a>b)
        return -1;
    else if(a<b)
        return 1;
    return 0;
});
console.log(array);

array.sort(function (a, b)
{
    return a.length - b.length;
});
console.log(array);