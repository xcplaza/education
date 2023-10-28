// Get the required elements from the DOM
const todoInput = document.getElementById('todoInput');
const addButton = document.getElementById('addButton');
const todoList = document.getElementById('todoList');

// Function to add a new ToDo when the button is clicked
function addTodo() {
    // Get the text from the input
    const todoText = todoInput.value;

    // Create a new list item element
    const li = document.createElement('li');

    // Create a span element to hold the ToDo text
    const todoTextSpan = document.createElement('span');
    todoTextSpan.textContent = todoText;

    // Create a button element to remove the ToDo
    const removeButton = document.createElement('button');
    removeButton.textContent = 'Remove';
    removeButton.addEventListener('click', () => {
        li.remove();
    });

    // Append the ToDo text and remove button to the list item
    li.appendChild(todoTextSpan);
    li.appendChild(removeButton);

    // Append the list item to the ToDo list
    todoList.appendChild(li);

    // Clear the input field
    todoInput.value = '';
}

// Add event listener to the button
addButton.addEventListener('click', addTodo);
