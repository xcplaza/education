import React, {Component} from 'react';
import Weather from "./Weather";
import {api_key, base_url} from "../utils/constants";
import FormControl from "./FormControl";

class Data extends Component
{
    constructor(props)
    {
        super(props);
        this.state = {weatherInfo:
                {
                    country: null,
                    city: null,
                    temp: null,
                    pressure: null,
                    sunset: null,
                    sunrise: null,
                    message: 'Enter your city'
                }};
    }

    // getWeather = city =>
    // {
    //     fetch(`${base_url}?q=${city}&appid=${api_key}`)
    //         .then(response => response.json())
    //         .then(data => this.setState({weatherInfo:
    //                 {
    //                     country: data.sys.country,
    //                     city: data.name,
    //                     temp: data.main.temp,
    //                     pressure: data.main.pressure,
    //                     sunset: data.sys.sunset,
    //                     sunrise: data.sys.sunrise
    //                 }}))
    //         .catch(error => console.log(error));
    // }

    getWeather = async city =>
    {
        try
        {
            const response = await fetch(`${base_url}?q=${city}&appid=${api_key}&units=metric`);
            const data = await response.json();
            this.setState({
                weatherInfo:
                    {
                        country: data.sys.country,
                        city: data.name,
                        temp: data.main.temp,
                        pressure: data.main.pressure,
                        sunset: data.sys.sunset,
                        sunrise: data.sys.sunrise,
                        message: null
                    }
            })
        } catch (e)
        {
            this.setState({weatherInfo:
                    {
                        message: 'Enter correct city name'
                    }})
        }
    }

    render()
    {
        return (
            <div>
                <FormControl getWeather={this.getWeather}/>
                <Weather weatherInfo={this.state.weatherInfo}/>
            </div>
        );
    }
}

export default Data;