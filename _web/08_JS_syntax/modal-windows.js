// alert('Hello')

// let res = confirm("Are you sure?");
// alert(res);

let num1 = prompt("Enter first number") || 0;
let num2 = prompt("Enter second number") || 0;
let operator = prompt("Enter operator [+, -, *, /]");
calc(num1, num2, operator);

function calc(num1, num2, operator) {
    if (operator == '+') {
        res = (+num1 + Number(num2));
    } else if (operator == '-') {
        res = num1 - num2;
    } else if (operator == '*') {
        res = num1 * num2;
    } else if (operator == '/') {
        if (num2 == 0) {
            alert('Cannot divide by zero');
            return;
        }
        res = num1 / num2;
    }
    return alert(res);
}

