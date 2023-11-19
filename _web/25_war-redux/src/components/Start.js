import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import {changePageAction, setNameAction} from "../redux/gameActions";
import {game} from "../constants";

const Start = () =>
{
    const [name, setName] = useState('')
    const dispatch = useDispatch()
    return (
        <div className={'playerForm'}>
            <h1 className={'readyForWar'}>Ready for war</h1>
            <input onChange={e => setName(e.target.value)} type='text'
                   placeholder='Enter your name' className={'playerName'} value={name}/>
            <button className={'startButton'} onClick={() =>
            {
                dispatch(changePageAction(game))
                dispatch(setNameAction(name))
            }}>Start</button>
        </div>
    );
}


export default Start;
