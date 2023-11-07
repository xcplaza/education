//rcc
import React, {Component} from 'react';

class Form extends Component
{
    handleSubmitGetCity = e =>
    {
        e.preventDefault();
        const city = e.currentTarget.city.value;
        this.props.getWeather(city);
    }
    // https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
    render()
    {
        return (
            <form onSubmit={this.handleSubmitGetCity}>
                <input type={'text'} name={'city'} placeholder={'Enter your city'}/>
                <button type={'submit'}>Get weather</button>
            </form>
        );
    }
}

export default Form;