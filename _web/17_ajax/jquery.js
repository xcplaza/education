// function AJAX
$.ajax({
    url: 'https://jsonplaceholder.typicode.com/posts/10',
    type: 'GET',
    // body:
    // headers:
    success: (result, status) => {
        console.log(result);
        console.log(status);
    },
    error: (result, status) => {
        console.log(result);
        console.log(status);
    }
})