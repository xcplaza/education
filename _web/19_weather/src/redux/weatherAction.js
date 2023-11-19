import {api_key, base_url} from "../utils/constants"

export const PUT_WEATHER = 'PUT_WEATHER';
export const PUT_MESSAGE = 'PUT_MESSAGE';

export const putWeatherAction = weatherInfo => ({
    type: PUT_WEATHER,
    payload: weatherInfo
});

export const putMessageAction = message => ({
    type: PUT_MESSAGE,
    payload: message
});

export const getWeatherAction = city => {
    return dispatch => {
        dispatch(putMessageAction('Loading...'));
        fetch(`${base_url}?q=${city}&appid=${api_key}&units=metric`)
            .then(response => response.json())
            .then(data => ({
                country: data.sys.country,
                city: data.name,
                temp: data.main.temp,
                pressure: data.main.pressure,
                sunset: data.sys.sunset,
                sunrise: data.sys.sunrise
            }))
            .then(weatherInfo => dispatch(putWeatherAction(weatherInfo)))
            .catch(() => dispatch(putMessageAction('Enter correct city name')));
    }
}

