import React, {Component} from 'react';

class Timer extends Component {
    intervalTic;
    intervalColor;
    colors = ['red', 'green', 'blue', 'orange'];

    constructor(props) {
        super(props);
        this.state = {
            time: new Date(),
            colorIndex: 0
        };
        // this.colors = ['red', 'green', 'blue', 'orange'];
    }


    tic = () => {
        console.log('time changed');
        this.setState({time: new Date(), colorIndex: this.state.colorIndex});
    }
    getColor = () => this.colors[this.state.colorIndex];

    componentDidMount() {
        this.intervalTic = setInterval(this.tic, 1000);
        this.intervalColor = setInterval(() => {
            console.log('color changed');
            let index = this.state.colorIndex + 1;
            if (index === this.colors.length) index = 0;
            this.setState({
                time: this.state.time,
                colorIndex: index
            })
        }, 2999);
    }

    componentWillUnmount() {
        clearInterval(this.intervalTic);
        clearInterval(this.intervalColor)
    }

    render() {
        return (
            <div>
                <h1 style={{color: this.getColor()}}>Current time</h1>
                <p> {this.state.time.toLocaleTimeString()}</p>
            </div>
        );
    }
}

export default Timer;