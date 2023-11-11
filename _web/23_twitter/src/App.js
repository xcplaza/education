import './App.css';

import React, {Component} from 'react';
import Body from "./component/Body";
import Nav from "./component/Nav";
import {TwitterContext} from "./utils/TwitterContext";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {
                avatar: require('./avatar.jpg'),
                name: 'Animal cat'
            },
            stats: {
                followers: 10,
                following: 3
            }
        }
    }

    render() {
        return (
            <div className={'app'}>
                <TwitterContext.Provider value={{user: this.state.user, stats: this.state.stats}}>
                    <Nav/>
                    <Body/>
                `</TwitterContext.Provider>
            </div>
        );
    }
}

export default App;
