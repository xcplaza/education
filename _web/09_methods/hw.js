function arrayCopy(srcArray, srcIndex, dstArray, dstIndex, length)
{
    let temp = srcArray.slice(srcIndex, srcIndex + length);
    dstArray.splice(dstIndex, 0, ...temp);
}
let src = [1,2,3,4,5,6];
let dst = [0,7,8,9];
arrayCopy(src, 0, dst, 1, 6);
console.log(dst);

function getNumbersWithDigitsAmount(digitsAmount, array)
{
    return array.filter(function (item)
    {
        item = Math.abs(item);
        return item.toString().length === digitsAmount;
    })
}
let array = [1,-10, -41, 40, 101, 1000, 45, 89, 98];
console.log(getNumbersWithDigitsAmount(2, array));

function oddEvenSort(array)
{
    // return [...array].sort(function (a, b)
    return array.slice().sort(function (a, b)
    {
        // if(a%2===0 && b%2!==0)
        //     return 1;
        // return -1;
        // return a%2===0 && b%2!==0 ? 1 : -1;
        return Math.abs(a%2) - Math.abs(b%2);
    });
//    a < b -> -1
//    a == b -> 0
//    a > b -> 1
}
console.log(oddEvenSort(array));
console.log(array);

function evenAscOddDesc(array)
{
    return array.slice().sort(function (a, b)
    {
        // if(a%2===0 && b%2!==0)
        //     return -1;
        // else if(a%2!==0 && b%2===0)
        //     return 1;
        // else if(a%2===0 && b%2===0)
        //     return a - b;
        // return b - a;
        let res = Math.abs(a%2) - Math.abs(b%2);//a even b even = 1   0-0=0
        if(res === 0)
            res = a%2===0 ? a - b : b - a;
        return res;
    })
}
//let array = [-10, 1, -41, 40, 101, 1000, 45, 89, 98];
console.log(evenAscOddDesc(array));