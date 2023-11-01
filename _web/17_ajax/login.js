const base_url = 'https://webaccounting.herokuapp.com';
const login = document.querySelector('#login');
const password = document.querySelector('#password');
const btn = document.querySelector('button');

// btn.onclick = () => {
//     const user = login.value.trim();
//     const pass = password.value.trim();
//     fetch(`${base_url}/account/login`, {
//         method: 'POST',
//         headers: {'Authorization': `Basic ${btoa(user + ':' + pass)}`}
//     })
//         .then(response => {
//             if (response.status === 200)
//                 return response.json()
//             else
//                 throw new Error(response.statusText)
//
//         })
//         .then(data => console.log(data))
//         .catch(error => console.log(error.message))
// }

btn.onclick = async () => {
    try {
        const user = login.value.trim();
        const pass = password.value.trim();
        let data;
        let response = await fetch(`${base_url}/account/login`, {
            method: 'POST',
            headers: {'Authorization': `Basic ${btoa(user + ':' + pass)}`}
        });
        if (response.status === 200)
            data = await response.json()
        else
            throw new Error(response.statusText);
        console.log(data);
    } catch (e) {
        console.log(e.message);
    }
}