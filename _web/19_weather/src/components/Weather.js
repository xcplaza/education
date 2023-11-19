import React from 'react';
import {useSelector} from "react-redux";

const Weather = () => {
    const {weatherInfo, message} = useSelector(state => state);
    return (
        <div style={{width: '60%', fontSize: '1vw', color: '#fff'}}>
            {!message &&
                <div>
                    <p>Location: {weatherInfo.country}, {weatherInfo.city}</p>
                    <p>Temperature: {weatherInfo.temp}<sup>o</sup></p>
                    <p>Pressure: {weatherInfo.pressure}</p>
                    <p>Sunset: {new Date(weatherInfo.sunset * 1000).toTimeString()}</p>
                    <p>Sunrise: {new Date(weatherInfo.sunrise * 1000).toTimeString()}</p>
                </div>
            }
            <p>{message}</p>
        </div>
    );
}

export default Weather;