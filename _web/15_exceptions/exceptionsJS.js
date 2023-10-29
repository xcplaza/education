let person = {name: 'Peter'}

function printName(obj) {
    try {
        console.log(obj.name);
        // console.log(obj.address.street);
        // console.log(obj.address.building);
        return;
    } catch (e) {
        console.log('Error: ' + e.message);
        console.log(e.name);
    } finally {
        console.log('This is finally block');
    }
}

// person = null;
printName(person);

function division(a, b) {
    if (b != 0) {
        return a / b;
    }
    throw new Error('Division by zero!');
}

try {
    division(10, 0);
    console.log(res);
} catch (e) {
    console.log(e.name);
    console.log(e.message);
}

console.log('Hello students!');

// evalError
// internalError
// rangeError
// referenceError
// syntaxError
// typeError