import React, {Component} from 'react';

class MyClassComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {title: 'old title'};
        console.log('constructor');
    }

    static getDerivedStateFromProps(props, state) {
        console.log('getDerivedStateFromProps', props, state);
    }

    componentDidMount() {
        console.log('componentDidMount');
        setTimeout(() => {
            this.setState({title: 'new title'});
        }, 2000);
    }

    render() {
        console.log('render');
        return (
            <div>
                {this.state.title}
            </div>
        );
    }
}

export default MyClassComponent;