import accountReducer from "./reducers/accountReducer";
import {createStore} from "redux";

const initialState = {balance: 10};

const store = createStore(accountReducer, initialState);
export default store;