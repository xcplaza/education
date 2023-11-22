import React, {useEffect, useState} from 'react';
import Task from "./Task";
import {addToDo, getAllTasks, updateTask} from "../config/dbConfig";
import {getUid} from "../config/authConfig";

const TaskList = () => {
    // const [tasks, setTasks] = useState(['add task']);
    // const [tasks, setTasks] = useState<Array<string>>([]);
    const [tasks, setTasks] = useState<string[]>([]);
    const [task, setTask] = useState<string>('');
    const [uid, setUid] = useState<string>()

    useEffect(() => {
        getUid()
            .then(data => {
                setUid(data);
                getAllTasks(data)
                    .then(t => setTasks([...t.todo]))
            })
            .catch(() => setUid('uid'));
    }, [tasks]);

    const taskEdit = (index: number, text: string) => {
        tasks.splice(index, 1, text);
        updateTask(uid, tasks);
    }

    const taskRemove = (index: number) => {
        tasks.splice(index, 1);
        updateTask(uid, tasks);
    }

    return (
        <div className='field'>
            <input type={'text'} placeholder={'Enter task'} value={task} onChange={e => setTask(e.target.value)}/>
            <button className={'btn new'} onClick={() => addToDo(uid, task)}>add task</button>
            {tasks.map((item, index) =>
                <Task key={index} updateTask={taskEdit} deleteTask={taskRemove} index={index}>
                    {item}</Task>)}
        </div>
    );
}

export default TaskList;