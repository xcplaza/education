import './App.css';
import React from 'react';
import Game from "./components/Game";
import Result from "./components/Result";
import Start from "./components/Start";
import {useSelector} from "react-redux";
import {game, result} from "./constants";

const App = () =>
{
    const page = useSelector(state => state.page);
    switch (page)
    {
        case game:
            return (
                <div className={'field'}>
                    <Game/>
                </div>
            )
        case result:
            return (
                <div className={'field'}>
                    <Result/>
                </div>
            )
        default:
            return (
                <div className={'field'}>
                    <Start/>
                </div>
            )
    }
};


export default App;

