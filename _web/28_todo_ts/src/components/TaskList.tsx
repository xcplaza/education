import React, {Component} from 'react';
import Task from "./Task";

interface State {
    tasks: string[];
}

class TaskList extends Component<any, State> {
    constructor(props: any) {
        super(props);
        this.state = {tasks: ['add task']};
    }

    taskEdit = (index: number, text: string) => {
        const temp = [...this.state.tasks];
        temp[index] = text;
        this.setState({tasks: temp});
    }

    taskRemove = (index: number) => {
        const temp = [...this.state.tasks];
        temp.splice(index, 1);
        this.setState({tasks: temp});
    }

    handleClickAddTask = () => {
        const temp = [...this.state.tasks];
        temp.push('New Task');
        this.setState({tasks: temp});
    }

    render() {
        return (
            <div className='field'>
                {/*<Task task='go to sleep'/>*/}
                {/*<Task task='go to drink coffee'/>*/}
                {/*<Task task='go to cinema'/>*/}
                {/*{this.state.tasks.map((item, index) => <Task task={item} key={index}/>)}*/}
                <button className={'btn new'} onClick={this.handleClickAddTask}>add task</button>
                {this.state.tasks.map((item, index) =>
                    <Task key={index} updateTask={this.taskEdit} deleteTask={this.taskRemove} index={index}>
                        {item}</Task>)}
            </div>
        );
    }
}

export default TaskList;