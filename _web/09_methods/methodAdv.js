let array = [10, 11, 3, 56, 7, -812, 11, 56];
let res;
for (let num in array)
{
    if(array[num] > 50)
    {
        res = array[num];
        break;
    }
}
console.log(res);

function predicate(num)
{
    return num > 50;
}
for (let i of array)
{
    if(predicate(i))
    {
        res = i;
        break;
    }
}
res = array.find(predicate);
res = array.find(function (num)
{
    return num > 50;
});
console.log(res);
res = array.find(function (num)
{
    return num > 5000;
});
console.log(res);
res = array.find(function (num, index)
{
    return num > 50 && index < 10;
});
console.log(res);

res = array.findIndex(function (num, index)
{
    return num > 50 && index%2==0;
});
console.log(res);
res = array.findIndex(function (num)
{
    return num > 50000;
});
console.log(res);

for (let i in array)
{
    if(predicate(array[i]))
    {
        res = i;
        break;
    }
}

res = array.filter(function (item)
{
    return item % 2 === 0;
})
console.log(res);

res = array.every(function (item)
{
    return item % 2 === 0;
});
console.log(res);
res = array.every(function (item)
{
    return item > -1000;
});
console.log(res);

res = array.some(function (item)
{
    return item % 2 === 0;
});
console.log(res);

res = array.some(function (item)
{
    return item < -1000;
});
console.log(res);

function arraySum(array)
{
    if(!array.every(function (item)
    {
        return typeof item === 'number';
    }))
        return 'Wrong data: This is not numbers array';

    let res = 0;
    for (let i of array)
    {
        res += i;
    }
    return res;
}
console.log(arraySum([1,2,3,4]));
console.log(arraySum([1,2,'hello',true]));

array = [1,2,'hello',true];
let type = typeof array[0];
res = array.every(function (item)
{
    return typeof item === type;
});
console.log(res);