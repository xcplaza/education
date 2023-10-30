// promise.all()

function getId() {
    return new Promise(resolve => {
        setTimeout(() => resolve(100), 500);
    })
}

function getName() {
    return new Promise(resolve => {
        setTimeout(() => resolve('Masha'), 1000);
    })
}

Promise.all([getId(), getName()])
    .then(array => console.log(`id: ${array[0]}, name: ${array[1]}`));

// Promise.race()
Promise.race([getId(), getName()])
    .then(res => console.log(res));