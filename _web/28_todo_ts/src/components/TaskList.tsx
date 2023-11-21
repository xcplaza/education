import React, {useState} from 'react';
import Task from "./Task";

const TaskList = () => {
    // const [tasks, setTasks] = useState(['add task']);
    // const [tasks, setTasks] = useState<Array<string>>([]);
    const [tasks, setTasks] = useState<string[]>([]);

    const taskEdit = (index: number, text: string) => {
        const temp = [...tasks];
        temp[index] = text;
        setTasks(temp);
    }

    const taskRemove = (index: number) => {
        const temp = [...tasks];
        temp.splice(index, 1);
        setTasks(temp);
    }

    const handleClickAddTask = () => {
        const temp = [...tasks];
        temp.push('New Task');
        setTasks(temp);
    }
    return (
        <div className='field'>
            {/*<Task task='go to sleep'/>*/}
            {/*<Task task='go to drink coffee'/>*/}
            {/*<Task task='go to cinema'/>*/}
            {/*{this.state.tasks.map((item, index) => <Task task={item} key={index}/>)}*/}
            <button className={'btn new'} onClick={handleClickAddTask}>add task</button>
            {tasks.map((item, index) =>
                <Task key={index} updateTask={taskEdit} deleteTask={taskRemove} index={index}>
                    {item}</Task>)}
        </div>
    );
}

export default TaskList;