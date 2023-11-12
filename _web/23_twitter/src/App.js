import './App.css';

import React, {useState} from 'react';
import Body from "./component/Body";
import Nav from "./component/Nav";
import {TwitterContext} from "./utils/TwitterContext";
import userAvatar from "./component/UserAvatar";

const App = () => {
    const [user, setUser] = useState({
        avatar: require('./avatar.jpg'),
        name: 'Animal cats'
    });

    const [stats, setStats] = useState({
        followers: 10,
        following: 3
    });

    const changeAvatar = url => setUser({avatar: url || user.avatar, name: user.name});
    // const changeName = name => setUser(user => ({...user, name: name || user.name}));
    const changeName = name => setUser({avatar: user.avatar, name: name || user.name});
    const changeState = (statsType, sum) => setStats(stats => {
        let res = stats[statsType] + sum;
        res = res < 0 ? 0 : res;
        return {...stats, [statsType]: res};
    })

    return (
        <div className={'app'}>
            <TwitterContext.Provider value={{user, stats, changeName, changeState, changeAvatar}}>
                <Nav/>
                <Body/>
            </TwitterContext.Provider>
        </div>
    );

}

export default App;
