fetch('https://jsonplaceholder.typicode.com/posts/10')
    .then(response => response.json())
    .then(data => {
        const h1 = document.createElement('h1');
        const h1Text = document.createTextNode(data.title);
        h1.append(h1Text);
        document.body.append(h1);
    })
    .catch(error => console.log(error));