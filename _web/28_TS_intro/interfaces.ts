interface Address {
    street: string;
    city: string;
    building: number | string;
}

interface Person {
    readonly id: number;
    firstName: string;
    lastName: string;
    address: Address;
    fullName: (greeting: string) => string;
}

let masha: Person = {
    address: {
        building: 1,
        city: 'Moscow',
        street: 'Lenina'
    },
    firstName: 'Masha',
    id: 1,
    lastName: 'Smith',
    fullName: function (greeting: string) {
        return `${greeting} ${this.firstName} ${this.lastName}`
    },
    // hobby: 'music'
};
console.log(masha.fullName('Ms'));
// masha.id = 10; // error because id is readonly property


let pasha = {
    address: {
        building: 1,
        city: 'Moscow',
        street: 'Lenina'
    },
    firstName: 'Pasha',
    id: 1,
    lastName: 'Smith',
    fullName: function (greeting: string) {
        return `${greeting} ${this.firstName} ${this.lastName}`
    },
    hobby: 'games'
};
pasha.id = 20;
let pasha1 = pasha as Person;
// pasha1.id = 5;
let pasha2: Person = <Person>pasha;
// pasha2.id = 5;
console.log(pasha1.fullName('Mr'));


enum Title {
    CLEANER = 'Cleaner',
    PROGRAMMER = 'Programmer',
    DEVOPS = 'DevOps',
    TESTER = 'Tester'
}

interface Employee extends Person {
    salary: number;
    title: Title
}


let sasha: Employee = {
    address: {
        building: 1,
        city: 'Moscow',
        street: 'Lenina'
    },
    firstName: 'Sasha',
    id: 1,
    lastName: 'Smith',
    fullName: function (greeting: string) {
        return `${greeting} ${this.firstName} ${this.lastName}`
    },
    salary: 100000,
    title: Title.PROGRAMMER
};
console.log(sasha);

let color: 'red' | 'green' | 'blue';
// color = "abc"; //error
color = "green";