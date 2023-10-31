const base_url = 'https://webaccounting.herokuapp.com';
const firstName = document.querySelector('#firstName');
const lastName = document.querySelector('#lastName');
const login = document.querySelector('#login');
const password = document.querySelector('#password');
const btn = document.querySelector('button');

btn.onclick = () => {
    const user = {
        "firstName": firstName.value.trim(),
        "lastName": lastName.value.trim(),
        "login": login.value.trim(),
        "password": password.value.trim()
    }

    fetch(`${base_url}/account/user`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(user)
    })
        .then(response => {
            if (response.status === 200)
                return response.json()
            else
                throw new Error(response.statusText)

        })
        .then(data => console.log(data))
        .catch(error => console.log(error.message))
}