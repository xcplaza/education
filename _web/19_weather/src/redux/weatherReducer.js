import {PUT_MESSAGE, PUT_WEATHER} from "./weatherAction";

const initialState = {message: 'Enter city name'};
export const weatherReducer = (state = initialState, action) => {
    switch (action.type) {
        case PUT_WEATHER:
            return {...state, weatherInfo: action.payload, message: null}
        case PUT_MESSAGE:
            return {...state, message: action.payload}
        default:
            return state;
    }
}