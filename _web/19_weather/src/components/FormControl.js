//rcc
import React, {Component} from 'react';

class FormControl extends Component
{
    constructor(props)
    {
        super(props);
        this.state = {city: ''};
    }

    handleChangeCity = e => this.setState({city: e.target.value})

    handleClickGetWeather = e =>
    {
        this.props.getWeather(this.state.city);
        this.setState({city: ''});
    }
    render()
    {
        return (
            <div>
                <input type={'text'} name={'city'} placeholder={'Enter your city'} value={this.state.city}
                    onChange={this.handleChangeCity}/>
                <button onClick={this.handleClickGetWeather}>Get weather</button>
            </div>
        );
    }
}

export default FormControl;
