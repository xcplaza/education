class Check extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            checked: false
        }
    }

    handleChangeCheck = () => {
        this.setState({checked: !this.state.checked});
    }

    render() {
        let message = this.state.checked ? ' checked' : ' not checked';
        return (
            <div>
                <input type={'checkbox'} checked={this.state.checked} onChange={this.handleChangeCheck}/>
                <p>checkbox is {message}</p>
            </div>
        );
    }
}

ReactDOM.render(<Check/>, document.getElementById('root'));