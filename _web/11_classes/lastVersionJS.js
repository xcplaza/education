class Person {
    name;
    lastName;
    static age = 30;
    #hiddenField; // for incapsulate

    constructor(name, lastName, hidden) {
        this.name = name || 'Anonymous';
        this._lastName = lastName;  // pseudo private
        this.#hiddenField = hidden; // for incapsulate - private
    }

    get hiddenField() {
        return this.#hiddenField;
    }

    set hiddenField(hidden) {
        this.#hiddenField = hidden;
    }

    displayName() {
        console.log(this.name);
    }

    static doSomething() {
        console.log(this.age);
    }
}

let p = new Person();
p.displayName();
console.log(Person.age);
Person.doSomething();

// incapsulate
// console.log(p.#hiddenField);
p.hiddenField = 123;
console.log(p.hiddenField);

for (let i in p) {
    console.log(i);
}