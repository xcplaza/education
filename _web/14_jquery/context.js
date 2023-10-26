const nameFunc = function () {
    console.log(this);
    return `${this.firstName} ${this.lastName}`;
}

let masha = {
    firstName: 'Masha',
    lastName: 'Smith',
}

let pasha = {
    firstName: 'Pasha',
    lastName: 'Smith',
}

window.firstName = 'JS';
this.lastName = 'SOS';
masha.fullName = nameFunc;
pasha.fullName = nameFunc;
console.log(nameFunc());
console.log(masha.fullName());
console.log(pasha.fullName());