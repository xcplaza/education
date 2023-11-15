import {DEPOSIT, WITHDRAW} from "../actions/accountActions";

function accountReducer(state, action) {
    switch (action.type) {
        case DEPOSIT:
            return {...state, balance: state.balance + action.payload};
        case WITHDRAW:
            let res = state.balance - action.payload;
            return {...state, balance: res < 0 ? state.balance : res};
        default:
            return state;
    }
}

export default accountReducer;