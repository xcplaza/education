class Person {
    constructor(firstName, lastName, age) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._age = age;
    }

    fullName = function () {
        return `${this._firstName} ${this._lastName}`;
    }

    get firstName() {
        return this._firstName;
    }

    set firstName(name) {
        this._firstName = name;
    }

    get age() {
        return this._age;
    }

    set age(age) {
        if (age.length > 3) {
            if (this._age < age) {
                this._age = age;
            }
        }
    }

    set firstName(name) {
        if (name.length > 3) {
            this._firstName = name;
        }
    }
}

let masha = new Person('Masha', 'Smith', 20);
console.log(masha);
console.log(masha.fullName());

masha._age = 21;
console.log(masha._age);

masha.age = 22;
console.log(masha.age);

// Employee.prototype = Person
class Employee extends Person {
    constructor(firstName, lastName, age, position, salary) {
        super(firstName, lastName, age);
        this._salary = salary;
    }

    get slary() {
        return this._salary;
    }

    set salary(salary) {
        this._salary = salary;
    }
}

let sasha = new Employee('Sasha', 'Smith', 25, 'developer', 10000);
console.log(sasha);