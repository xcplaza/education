class User {
    constructor(nickName) {
        this.nickName = nickName;
    }

    infoFunc = function () {
        console.log(this.nickName);
    }
}

let masha = new User('Masha');
// masha.infoFunc();
// let name = masha.infoFunc; // -> error
let name = masha.infoFunc.bind(masha);
name();

let pasha = new User('Pasha');
name = masha.infoFunc.bind(pasha);
name();


masha.infoFunc.call({nickName: 'call'});
masha.infoFunc.apply({nickName: 'apply'});

// masha.infoFunc();
function printInfo(func) {
    func();
}

printInfo(masha.infoFunc.bind({nickName: 'Gosha'}));
// bind call(value1, value2) apply([value1, value2])