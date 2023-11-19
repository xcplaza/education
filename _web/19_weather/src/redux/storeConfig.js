import {applyMiddleware, createStore} from "redux";
import {weatherReducer} from "./weatherReducer";
import thunk from "redux-thunk";
import {logger} from "redux-logger/src";

export const store = createStore(weatherReducer, applyMiddleware(thunk, logger));