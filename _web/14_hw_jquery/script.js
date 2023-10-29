let group = {
    title: 'Karmiel',
    students: ["Alina", "Hana"],
    showList: function () {
        const show = function (name) {
            console.log(`${this.title}: ${name}`);
        }
        this.students.forEach(show);
    }
}
group.showList();
let newGroup = group;
group = null;
console.log("===========");
newGroup.showList();

//This piece of code there is a lost of context, and instead of your title it will be displayed undefined.
// You must solve the loss of context problem in every possible way. There are 4 in total
// 1 solution
console.log("=========== 1");
group = {
    title: 'Karmiel',
    students: ["Alina", "Hana"],
    showList: function () {
        const show = function (name) {
            console.log(`${this.title}: ${name}`);
        }.bind(this); // bind the show function to the group object
        this.students.forEach(show);
    }
};
group.showList();

// 2 solution
console.log("=========== 2");
group = {
    title: 'Karmiel',
    students: ["Alina", "Hana"],
    showList: function () {
        const show = (name) => { // use an arrow function for show
            console.log(`${this.title}: ${name}`);
        };
        this.students.forEach(show);
    }
};
group.showList();

// 3 solution
console.log("=========== 3");
group = {
    title: 'Karmiel',
    students: ["Alina", "Hana"],
    showList: function () {
        const show = function (name) {
            console.log(`${this.title}: ${name}`);
        };
        this.students.forEach((name) => {
            show.call(this, name); // explicitly specify the context using call
        });
    }
};
group.showList();

// 4 solution
console.log("=========== 4");
group = {
    title: 'Karmiel',
    students: ["Alina", "Hana"],
    showList: function () {
        const self = this; // store the value in a separate variable
        const show = function (name) {
            console.log(`${self.title}: ${name}`); // use self instead of this
        };
        this.students.forEach(show);
    }
};
group.showList();