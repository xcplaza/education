class Task extends React.Component {

    constructor(props) {
        super(props);
        this.handleClickEdit = this.handleClickEdit.bind(this);
        this.state = {isEdit: false};
        this.newText = React.createRef();
    }

    handleClickEdit = function () {
        this.setState({isEdit: true});
    }
    handleClickRemove = () => this.props.deleleTask(this.props.index);
    handleClickSave = () => {
        const value = this.newText.current.value;
        this.props.updateTask(this.props.index, value);
        this.setState({isEdit: false});
    }

    renderNorm = () => {
        return (
            <div className={'box'}>
                <div>{this.props.task}</div>
                <button className={'btn light'} onClick={this.handleClickEdit}>Edit</button>
                <button className={'btn red'} onClick={this.handleClickRemove}>Remove</button>
            </div>
        )
    }
    renderEdit = () => {
        return (
            <div className={'box'}>
                <textarea ref={this.newText} defaultValue={this.props.task}></textarea>
                <button className={'btn success'} onClick={this.handleClickSave}>Save</button>
            </div>
        )
    }

    render() {
        return this.state.isEdit ? this.renderEdit() : this.renderNorm();
    }
}

class TaskList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {tasks: ['add tasks']};
    }

    taskEdit = (index, text) => {
        const temp = [...this.state.tasks];
        temp[index] = text;
        this.setState({tasks: temp});
    }
    taskRemove = index => {
        const temp = [...this.state.tasks];
        temp.splice(index, 1);
        this.setState({tasks: temp});
    }
    handleClickAddTask = () => {
        const temp = [...this.state.tasks];
        temp.push('New task');
        this.setState({tasks: temp});
    }

    render() {
        return (
            <div className={'field'}>
                <button className={'btn new'} onClick={this.handleClickAddTask}>Add task</button>
                {this.state.tasks.map((item, index) =>
                    <Task task={item} key={index} updateTask={this.taskEdit} deleleTask={this.taskRemove}
                          index={index}/>)}
                {/*<Task task={'go to sleep'}/>*/}
                {/*<Task task={'go ot drink coffee'}/>*/}
                {/*<Task task={'go to work'}/>*/}
                {/*OR*/}
                {/*<Task>go to sleep</Task>*/}
                {/*<Task>go to drink coffee</Task>*/}
                {/*<Task>go to work</Task>*/}
            </div>
        );
    }
}

ReactDOM.render(<TaskList/>, document.querySelector('#root'));