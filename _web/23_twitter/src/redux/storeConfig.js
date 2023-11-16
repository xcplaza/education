import {createStore} from "redux";
// import {twitterReducer} from "./reducers/twitterReducer";
import {rootReducer} from "./reducers/rootReducer";

export const store = createStore(rootReducer);