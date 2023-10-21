// 1. function luckyNumber(number)
// Функция должна возвращать true, если число является счастливым, и false, если нет.
//     Число считается счастливым, если сумма всех четных цифр в данном месте числа равна сумме нечетных.  Например
// 121212 - не повезло -> 1+1+1 не равно 2+2+2
// 112233 - повезло -> 1+2+3 равно 1+2+3

function luckyNumber(number) {
    let str = number.toString();
    let sum = 0;
    for (let i = 0; i < str.length; i++) {
        if (i % 2 === 0) {
            sum += +str[i];
        } else {
            sum -= +str[i];
        }
    }
    return sum === 0;
}

console.log(luckyNumber('112233'));

//2. функция getDigitsSum(num)
// Функция принимает любое число и возвращает сумму цифр в целой части числа Примеры вызова функции и возвращаемых результатов
// Вызов: getDigitsSum(123.45); Ожидаемый результат: 6
// Вызов: getDigitsSum(-280.123); Ожидаемый результат: 10
// Вызов: getDigitsSum(123); Ожидаемый результат: 6

function getDigitsSum(num) {
    const str = Math.abs(num).toString().split('.')[0];
    let sum = 0;

    for (const digit of str) {
        const parsedDigit = parseInt(digit);
        if (!isNaN(parsedDigit)) {
            sum += parsedDigit;
        }
    }

    return sum;
}

console.log(getDigitsSum('-280.123'));

//3. функция computeExpression(expression)
// Задача поиска решения в Интернете. Написать функцию computeExpression, которая принимает строку, содержащую любое математическое выражение, и возвращает результат вычисления. Код функции содержит только одну строку
// Примеры вызова функции и возвращаемых результатов
// Вызов: computeExpression("9000 / ((10 + 20) ** 2)"); Ожидаемый результат: 10
// Вызов: computeExpression("9 + 100 / 2"); Ожидаемый результат:: 59

function computeExpression(expression) {
    return eval(expression);
}

console.log(computeExpression("9 + 100 / 2"));

// 4. function reverse(number)
// Function takes any number and returns string comprising of the digits of the integer part of the given number in the reversed order. Sign “-” should be kept in the result
// Examples of the function calls and being returned results
// Call: reverse(123.45); Expected result: “321”
// Call: reverse(-280.123); Expected result: “-082”
// Call: reverse(123); Expected result: “321”
// Call: reverse(-123); Expected result: “-321”

function reverse(number) {
    const numberString = Math.abs(number).toString();
    const reversedNumberString = numberString.split('').reverse().join('');
    const reversedNumber = number < 0 ? `-${reversedNumberString}` : reversedNumberString;
    return reversedNumber;
}

console.log(reverse(-123));

//5. функция factorial(x)
// Метод возвращает факториал переданного числа.

function factorial(x) {
    let result = 1;
    for (let i = 1; i <= x; i++) {
        result *= i;
    }
    return result;
}

console.log(factorial(5));

//6. function isPalindrome(str);
// Метод должен возвращать true, если строка является палиндромом, и false, если не является.Метод должен быть нечувствителен к регистру.Примеры:
//     "aba" -> true
//     "abcd" -> false
//     "aa aa" -> true
//     "Abba" -> true    "  Abba" -> true

function isPalindrome(str) {
    const lowerCaseStr = str.toLowerCase();
    const reversedStr = lowerCaseStr.split('').reverse().join('');
    return lowerCaseStr === reversedStr;
}

console.log(isPalindrome('Abba'));

//7. function reverseString(str)
// Function takes a string and returns a new string, which will be the reverse of the incoming string.
// Example:
// "mama" -> "amam"
// "Hello world" -> "dlrow olleH"

function reverseString(str) {
    return str.split('').reverse().join('');
}

console.log(reverseString("Hello world"));

//8. function countChar(str, c)
// Function counts and prints to the console how many times the transmitted character occurs in the specified string
// Example:
// "Hello world", 'l' -> 3

function countChar(str, c) {
    let count = 0;
    for (let i = 0; i < str.length; i++) {
        if (str[i] === c) {
            count++;
        }
    }
    return count;
}

console.log(countChar("Hello world", 'l'));

//9. function ulSurround(array)
// Function surrounds array of strings inside <ul></ul> element.
// Example of input array ["abc","lmn","cd"]
// Output array for the above example- ["<ul>","<li>abc</li>","<li>lmn</li>","<li>cd</li>","</ul>"]
// Apply the array functions: splice and map

function ulSurround(array) {
    return array.map(item => `<ul><li>${item}</li></ul>`);
}

console.log(ulSurround(["abc", "lmn", "cd"]));

//10. function count(array, elem)
// Function returns how many times a given element encountered in a given array
// Example of input array let strings=["abc","lmn","cd","abc","abc"]
// Output for the above example count(strings,"abc") will be 3 and count(strings,"ab") will be 0
// Apply the array function reduce

function count(array, elem) {
    return array.reduce((acc, item) => {
        if (item === elem) {
            acc++;
        }
        return acc;
    }, 0);
}

console.log(count(["abc", "lmn", "cd", "abc", "abc"], "abc"));