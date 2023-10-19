// Write function arrayCopy that gets the following parameters : function arrayCopy(src,srcPos,dst,dstPos,length) {....}
// where: src - source array, srcPos - index of the source array, dst - array destination, dstPos - index of destination array, length - number of elements. This function should copy length elements from src array beginning from srcPos index to dst array from dstPos index
// Apply the following array functions (splice and slice)

function arrayCopy(src, srcPos, dst, dstPos, length) {
    let temp = src.slice(srcPos, srcPos + length);
    dst.splice(dstPos, 0, ...temp);
}

let src = [1, 2, 3, 4, 5, 6];
let dst = [0, 7, 8, 9];
arrayCopy(src, 0, dst, 1, 6);
console.log(dst);

//2. Write function getNumbersWithDigitsAmount(digitsAmount, array), where digitsAmount - given number of digits, array - any array of integer numbers. Returns array of only numbers from the given array comprising of the given number of digits.
// Examples: getNumbersWithDigitsAmount(3, [1, 100, -100, 25, 1000]) returns [100, -100]
function getNumbersWithDigitsAmount(digitsAmount, array) {
    return array.filter(function (item) {
        item = Math.abs(item);
        return item.toString().length === digitsAmount;
    });
}

let array = [1, -200, 1001, 1, 30, 40, -50, 600, 9001, 17, 45];
console.log(getNumbersWithDigitsAmount(2, array));

//3. Write function of sorting oddEvenSort(array)
// Example input array [20, -10,333,1000, 552, 7, -7] => [333, 7, -7, 20, -10, 1000, 552]
function oddEvenSort(array) {
    return [...array].sort(function (a, b) {
        // if (a % 2 === 0 && b % 2 !== 0)
        //     return 1;
        // return -1;
        return a % 2 === 0 && b % 2 !== 0 ? 1 : -1;
    });
}

console.log(oddEvenSort(array));

//4. Write function of sorting evenAscOddDesc(array)
// Example input array [20, -10,333,1000, 552, 7, -7] => [-10, 20, 552, 100, 333, 7, -7]
function evenAscOddDesc(array) {
    return array.slice().sort(function (a, b) {
        // if (a % 2 === 0 && b % 2 !== 0)
        //     return -1;
        // else if (a % 2 !== 0 && b % 2 === 0)
        //     return 1;
        // else if (a % 2 === 0 && b % 2 === 0)
        //     return a - b;
        // else
        //     return b - a;
        let res = Math.abs(a % 2) - Math.abs(b % 2); // a - even, b - odd = -1  /  a - odd, b - even = 1
        if (res === 0)
            res = a % 2 === 0 ? a - b : b - a;
        return res;
    })
}

console.log(evenAscOddDesc(array));