import {CHANGE_PAGE, SET_COMP_WINS, SET_NAME, SET_PLAYER_WINS} from "./gameActions";
import {start} from "../constants";
const initialState =
    {
        page: start,
        name: '',
        playerWins: 0,
        compWins: 0
    };
export const gameReducer = (state = initialState, action) =>
{
    switch (action.type)
    {
        case SET_NAME:
            return {...state, name: action.payload};
        case CHANGE_PAGE:
            return {...state, page: action.payload};
        case SET_PLAYER_WINS:
            return {...state, playerWins: action.payload};
        case SET_COMP_WINS:
            return {...state, compWins: action.payload};
        default:
            return state;
    }
}
