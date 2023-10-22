function Point(x, y) {
    this.x = x;
    this.y = y;
}

let point = new Point(10, 20);
let point1 = new Point(1, 2);
console.log(point);

let point2 = Point(1, 3);
console.log(point2);

function Point1(a, b) {
    if (typeof a === 'number' && typeof b === 'number') {
        this.x = a;
        this.y = b;
    }
    this.field1 = a;
    this.field2 = b;
}

point2 = new Point1(1, 4);
console.log(point2);