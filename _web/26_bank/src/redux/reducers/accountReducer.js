import {DEPOSIT, WITHDRAW} from "../actions/accountActions";
import {PUT_QUOTE, QUOTE_ERROR, QUOTE_PENDING} from "../actions/quoteAction";

function accountReducer(state, action) {
    switch (action.type) {
        case DEPOSIT:
            return {...state, balance: state.balance + action.payload};
        case WITHDRAW:
            let res = state.balance - action.payload;
            return {...state, balance: res < 0 ? state.balance : res};
        case PUT_QUOTE:
        case QUOTE_PENDING:
        case QUOTE_ERROR:
            return {...state, quote: action.payload};
        default:
            return state;
    }
}

export default accountReducer;