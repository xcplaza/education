import accountReducer from "./reducers/accountReducer";
import {applyMiddleware, createStore} from "redux";
// import {loggerEnhancer} from "./enhancers/loggerEnhancer";
// import {thunkEnhancer} from "./enhancers/thunkEnhancer";
import thunk from "redux-thunk";
import {logger} from "redux-logger/src";

const initialState = {balance: 10, quote: 'Future is coming...'};

// const store = createStore(accountReducer, initialState, applyMiddleware(thunkEnhancer, loggerEnhancer));
const store = createStore(accountReducer, initialState, applyMiddleware(thunk, logger));
export default store;