import './App.css';
import React, {useState} from 'react';
import {TwitterContext} from "./utils/TwitterContext";
import Nav from "./component/Nav";
import Body from "./component/Body";

const App = () =>
{
    const [user, setUser] = useState(
        {
            avatar: 'https://oir.mobi/uploads/posts/2021-04/1619701495_42-oir_mobi-p-sonnii-kotik-zhivotnie-krasivo-foto-43.jpg',
            name: 'Pussy cat'
        });

    const [stats, setStats] = useState(
        {
            followers: 10,
            following: 1
        });

    const changeAvatar = url => setUser({avatar: url || user.avatar, name: user.name});

    // const changeName = name => setUser(user => ({...user, name: name || user.name}));
    const changeName = name => setUser({avatar: user.avatar, name: (name || user.name)});

    const changeStats = (statsType, sum) => setStats(stats =>
    {
        let res = stats[statsType] + sum;
        res = res < 0 ? 0 : res;
        return {...stats, [statsType]: res};
    })

    return (
        <div className={'app'}>
            <TwitterContext.Provider value={{user, stats, changeAvatar, changeName, changeStats}}>
                <Nav/>
                <Body/>
            </TwitterContext.Provider>
        </div>
    );
}

export default App;