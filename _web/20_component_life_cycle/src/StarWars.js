import React, {Component} from 'react';

class StarWars extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            hero: null
        }
    }

    componentDidMount() {
        fetch('https://sw-info-api.herokuapp.com/v1/peoples/4')
            .then(response => response.json())
            .then(data => {
                this.setState({
                    isLoading: false,
                    hero: data.name
                })
            })
    }

    render() {
        return (
            <div>
                <h1>{this.state.isLoading ? 'Loading...' : this.state.hero}</h1>
            </div>
        );
    }
}

export default StarWars;