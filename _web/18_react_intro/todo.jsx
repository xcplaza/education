class Task extends React.Component {
    render() {
        return (
            <div className={'box'}>
                <div>Task</div>
                <button className={'btn light'}>Edit</button>
                <button className={'btn red'}>Remove</button>
            </div>
        )
    }
}

ReactDOM.render(
    <div className={'field'}>
        <Task/>
        <Task/>
        <Task/>
    </div>, document.querySelector('#root'));