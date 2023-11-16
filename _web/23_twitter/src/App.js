import './App.css';
import React from 'react';
import Nav from "./component/Nav";
import Body from "./component/Body";

const App = () =>
{
    return (
        <div className={'app'}>
                <Nav/>
                <Body/>
        </div>
    );
}

export default App;