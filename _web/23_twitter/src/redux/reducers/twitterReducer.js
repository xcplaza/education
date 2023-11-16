import {CHANGE_AVATAR, CHANGE_NAME} from "../actions/userActions";
import {CHANGE_STATS} from "../actions/statAction";

export const twitterReducer = (state, action) => {
    let user;
    switch (action.type) {
        case CHANGE_NAME:
            user = {...state.user, name: action.payload || state.user.name};
            return {...state, user};
        case CHANGE_AVATAR:
            user = {...state.user, avatar: action.payload || state.user.avatar};
            return {...state, user};
        case CHANGE_STATS:
            let res = state.stats[action.payload.statsType] + action.payload.sum;
            let stats = {...state.stats, [action.payload.statsType]: res < 0 ? 0 : res};
            return {...state, stats};
        default:
            return state;
    }

}