const div = document.querySelector('div');
const newP = document.createElement('p');
const newPText = document.createTextNode('This is new text');
newP.className = 'active';

newP.appendChild(newPText);
// div.appendChild(newP);
div.insertBefore(newP, div.firstElementChild);

// clone node
const newP1 = newP.cloneNode(true);
div.insertBefore(newP1, div.firstElementChild);

//  node.append(...string or node) -> appendChild
//  node.prepend(...string or node)
//  node.before(...string or node)
// node.after(...string or node)
// node.replaceWith(...string or node)

div.append('append');
div.prepend('prepend');
div.before('before');
div.after('after');

const newP2 = newP.cloneNode(true);
const newP3 = newP.cloneNode(true);

// div.appendChild(newP2);
// div.appendChild(newP3);
div.append(newP2, newP3);


//  clock
div.replaceChild(newP3, div.firstElementChild.nextElementSibling.nextElementSibling);

document.body.append(document.createElement('section'));
const clock = document.querySelector('section');
setInterval(function () {
    const d = new Date().toTimeString();
    const time = document.createTextNode(d);
    clock.firstChild ? clock.replaceChild(time, clock.firstChild) : clock.appendChild(time);
})

div.removeChild(div.firstElementChild.nextElementSibling.nextElementSibling)