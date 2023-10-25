const input = document.querySelector('input');
const li = document.querySelector('li');

console.log(li.attributes); // get all attributes
console.log(li.dataset); // get custom attributes

console.log(input.attributes);
console.log(input.hasAttribute('id'));
console.log(input.getAttribute('value'));
input.setAttribute('id', 'myInput');
console.log(input.hasAttribute('id'));
console.log(input.getAttribute('id'));
input.removeAttribute('type');

// custom attributes -> data-attributes, data-mysize etc

