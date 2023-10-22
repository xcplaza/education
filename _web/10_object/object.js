let point = {
    x: 10,
    y: 20,
    'my hobby': 'game',
    '1field': true,
    toString: function () {     //CONVERT OBJECT TO JSON
        return JSON.stringify(this);
    }
}
console.log(typeof point);
console.log(point.x);
console.log(point['x']);

// ONLY []
console.log(point['my hobby']);
console.log(point["1field"]);

let str = 'my hobby';
console.log(point[str]);

console.log(point.z);
console.log(point['z']);

console.log(point);
console.log('point = ' + point);
console.log('point =', point); //ONLY console

point.x = 100;
point.z = 1;
console.log(point);

delete point['1field'];
console.log(point);

function numIncrement(number) {
    return number++;
}

console.log('IMMUTABLE PRIMITIVE =================================');
let number = 10;
numIncrement(number);
console.log(number);    //10

console.log('CHANGE OBJECT =================================');

function pointIncrement(object) {
    object.x++;
    object.y++;
}

pointIncrement(point);
console.log(point);

console.log('METHODS =================================');
console.log(Object.keys((point)));
console.log(Object.values(point));
console.log(Object.entries(point));

for (let entry of Object.entries(point)) {
    console.log(`${entry[0]} -> ${entry[1]}`);
}

console.log('CLONE =================================');
let point1 = point;
point1.bool = true;
console.log(point);

point1 = {...point};
point1.bool = false;
console.log(point);
console.log(point);

let job = {company: 'IBM', position: 'Software Engineer'};
point1 = {...point, salary: 10000, position: job.position};
console.log(point1);
point1 = {...point, salary: 10000, ...job};
console.log(point1);

point1 = {...point, salary: 10000, job: job};
console.log(point1);
// OR
point1 = {...point, salary: 10000, job};
console.log(point1);

console.log('CLONE and ASSIGN =================================');
point1 = Object.assign({}, point, job, {salary: 90000, gender: 'male'});
console.log(point1);

console.log('EQUALS =================================');
point = {x: 10, y: 20};
point1 = {x: 10, y: 20};
console.log(point.x === point1.x);
console.log(point.y === point1.y);
console.log(point.x === point1.x && point.y === point1.y);
console.log(point == point1);  //false
console.log(point === point1); //false

console.log(JSON.stringify(point) === JSON.stringify(point1)); //true
