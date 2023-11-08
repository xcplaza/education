import React, {Component} from 'react';

class MyClassComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {title: 'old title'};
        console.log('constructor');
    }

    static getDerivedStateFromProps(nextProps, nextState) {
        console.log('getDerivedStateFromProps', nextProps, nextState);
        return nextState;
    }

    componentDidMount() {
        console.log('componentDidMount');
        setTimeout(() => {
            this.setState({title: Math.random() < 0.5 ? 'new title' : 'old title'});
        }, 2000);
    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        console.log('shouldComponentUpdate', nextProps, nextState, nextContext);
        return this.state.title !== nextState.title;
    }

    getSnapshotBeforeUpdate(prevProps, prevState) {
        console.log('getSnapshotBeforeUpdate', prevProps, prevState);
        return prevState;
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log('componentDidUpdate', prevProps, prevState, snapshot);
    }

    componentWillUnmount() {
        console.log('componentWillUnmount');
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