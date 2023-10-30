// function sleep(timeout, fn) {
//     setTimeout(fn, timeout);
// }
//
// sleep(2000, () => console.log('After 2 seconds'));

function sleep(timeout) {
    return new Promise((resolve, reject) => {
        setTimeout(() => resolve, timeout);
    })
}

sleep(1000)
    .then(() => console.log('After 1 second'))
    .catch(() => alert('Error'));

// function getId(fn1, fn2) {
//     setTimeout(() => {
//         let id = Math.round(Math.random() * 10);
//         fn1(id, fn2);
//     }, 500);
// }
//
// function getUser(id, fn) {
//     setTimeout(() => {
//         let user = {id, name: 'John'};
//         fn(user);
//     }, 500)
// }

function getId() {
    return new Promise((resolve) => {
        setTimeout(() => {
            let id = Math.round(Math.random() * 10);
            resolve(id);
        }, 500);
    })
}

function getUser(id, fn) {
    return new Promise((resolve) => {
        setTimeout(() => {
            let user = {id, name: 'John'};
            resolve(user);
        }, 500)
    })
}

function displayUser(user) {
    console.log(user);
}

// getId(getUser, displayUser);
getId().then(getUser).then(displayUser).catch(() => alert('error'));

function willBeAnswer() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            let isAngry = Math.random() > 0.5;
            isAngry ? reject(new Error('I am Angry')) : resolve({answer: 'You are lucky'});
        }, 1000);
    })
}

willBeAnswer().then(res => console.log(res)).catch(error => console.log(error.message));