import {userReducer} from "./userReducer";
import {statsReducer} from "./statsReducer";
import {combineReducers} from "redux";

// export const rootReducer = (state, action) => {
//     return {
//         user: userReducer(state.user, action),
//         stats: statsReducer(state.stats, action)
//     }
// }

// OR combine reducer
export const rootReducer = combineReducers({
    user: userReducer,
    stats: statsReducer
})