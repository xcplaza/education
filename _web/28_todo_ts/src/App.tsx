import React, {useState} from 'react';
import './App.css';
import AuthComponent from "./components/AuthComponent";
import TaskList from "./components/TaskList";

function App() {
    const [page, setPage] = useState('auth');
    const [disabled, setDisabled] = useState(true);

    return (
        <div className={'field'}>
            <button onClick={() => setPage('auth')}>Authorization</button>
            <button onClick={() => setPage('todo')} disabled={disabled}>ToDoList</button>
            {page === 'auth' ? <AuthComponent disabledTodo={setDisabled}/> : <TaskList/>}
        </div>
    );
}

export default App;
