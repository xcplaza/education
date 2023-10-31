const base_url = 'https://jsonplaceholder.typicode.com/';
const input = document.querySelector('input');
const btn = document.querySelector('button');

btn.onclick = () => {
    let value = input.value.trim();
    input.value = '';
    fetch(`${base_url}users`)
        .then(response => response.json())
        .then(array => array.find(user => user.username === value).id)
        .then(id => fetch(`${base_url}posts/?userId=${id}`))
        .then(response => response.json())
        .then(array => array[0])
        .then(post => {
            document.body.innerHTML += `<h1>Title: ${post.title}</h1>
                                        <h3>Body: ${post.body}</h3>`;
        })
        .catch(error => alert(error));
}