import {CHANGE_STATS} from "../actions/statAction";

const state = {
    followers: 10,
    following: 1
}
export const statsReducer = (stats = state, action) => {
    switch (action.type) {
        case CHANGE_STATS:
            let res = stats[action.payload.statsType] + action.payload.sum;
            return {...stats, [action.payload.statsType]: res < 0 ? 0 : res};
        default:
            return stats;
    }

}