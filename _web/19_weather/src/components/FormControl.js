import React, {Component, useState} from 'react';
import {useDispatch} from "react-redux";
import {getWeatherAction, putWeatherAction} from "../redux/weatherAction";

const FormControl = () => {
    const [city, setCity] = useState('');
    const dispatch = useDispatch();
    const handleClickGetWeather = e => {
        dispatch(getWeatherAction(city))
        setCity('');
    }
    return (
        <div>
            <input type={'text'} name={'city'} placeholder={'Enter your city'} value={city}
                   onChange={(event) => setCity(event.target.value)}/>
            <button onClick={handleClickGetWeather}>Get weather</button>
        </div>
    );
}

export default FormControl;
