import React, {Component} from 'react';

class Weather extends Component
{
    render()
    {
        return (
            <div style={{width: '60%', fontSize: '1vw', color: '#fff'}}>
                {!this.props.weatherInfo.message &&
                    <div>
                        <p>Location: {this.props.weatherInfo.country}, {this.props.weatherInfo.city}</p>
                        <p>Temperature: {this.props.weatherInfo.temp}<sup>o</sup></p>
                        <p>Pressure: {this.props.weatherInfo.pressure}</p>
                        <p>Sunset: {new Date(this.props.weatherInfo.sunset * 1000).toTimeString()}</p>
                        <p>Sunrise: {new Date(this.props.weatherInfo.sunrise * 1000).toTimeString()}</p>
                    </div>
                }
                <p>{this.props.weatherInfo.message}</p>
            </div>
        );
    }


    // render()
    // {
    //     if (this.props.weatherInfo.message)
    //         return (
    //             <div>
    //                 <p>{this.props.weatherInfo.message}</p>
    //             </div>
    //         )
    //     else
    //         return (
    //             <div>
    //                 <p>Location: {this.props.weatherInfo.country}, {this.props.weatherInfo.city}</p>
    //                 <p>Temperature: {this.props.weatherInfo.temp}</p>
    //                 <p>Pressure: {this.props.weatherInfo.pressure}</p>
    //                 <p>Sunset: {this.props.weatherInfo.sunset}</p>
    //                 <p>Sunrise: {this.props.weatherInfo.sunrise}</p>
    //             </div>
    //         );
    // }
}

export default Weather;