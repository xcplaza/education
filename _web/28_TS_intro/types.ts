type Login = string;
let nickName: Login = 'Nik';

type ID = string | number;
let id: ID = 1234;
let id1: ID = '1234';
// let id2: ID = true;

type User = {
    email: string;
    password: string | number;
    // birthDate?: Date;
    [key: string]: string | number | boolean | Date;
};

let sasha: User = {
    email: 'a@a.com',
    password: '123456',
    birthDate: new Date(),
    hobby: 'sport'
};

let masha: User = {
    email: 'b@b.com',
    password: 123456,
    hasChildren: true
};

console.log(masha.birthDate)

type Area = {
    width: number;
    depth: number;
    area: () => number;
};

type Height = {
    height: number;
};
type Wardrobe = Height & Area;

let w: Wardrobe = {
    width: 10,
    depth: 20,
    height: 30,
    area: function () {
        return this.width * this.depth
    }
};