const human = {
    hobby: 'game',
    fullName: function () {
        return `${this.firstName} ${this.lastName}`;
    }
};
const masha = {
    firstName: 'Masha',
    lastName: 'Smith'
};

console.log(masha.firstName);
console.log(masha.lastName);
console.log(masha.hobby);

console.log(masha['__proto__'])
masha.__proto__ = human;
console.log(masha.hobby);
console.log(masha.fullName());

let pasha = {
    firstName: 'Pasha',
    lastName: 'Smith'
}
pasha.__proto__ = human;
console.log(pasha.hobby);


// CONSTRUCTOR
function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

// Prototype for constructor
Person.prototype = human;

let sasha = new Person('Sasha', 'Smith');
console.log(sasha.fullName());
console.log(sasha);

//toString for prototype
Person.prototype.toString = function () {
    return `First name: ${this.firstName}, Last name: ${this.lastName}, Hobby; ${this.hobby}`;
};
sasha = new Person('Sasha', 'Smith');
console.log(sasha.fullName());
console.log(sasha.toString());

// if field is enherited = false
console.log(sasha.hasOwnProperty('firstName'));
console.log(sasha.hasOwnProperty('hobby'));

//Write function displayOccurrences(array)
// Array contains the repeated strings, for example [‘abc’, ‘lmn’, ‘abc’, ‘lmn’,’lmn’, ‘prst’, ‘ab’]
// The function should display out the words and how many times each word is encountered in the array in the format as shown below. The words order isn’t defined. For example:
//        abc -> 2
//        lmn -> 3
//       ‘prst’ ->1
//       ‘ab’ ->1

function displayOccurrences(array) {
    let obj = {};
    for (let i = 0; i < array.length; i++) {
        if (obj[array[i]]) {
            obj[array[i]]++;
        } else {
            obj[array[i]] = 1;
        }
    }
    for (let entry of Object.entries(obj)) {
        console.log(`${entry[0]} -> ${entry[1]}`);
    }
}

displayOccurrences(['abc', 'lmn', 'abc', 'lmn', 'lmn', 'prst', 'ab']);