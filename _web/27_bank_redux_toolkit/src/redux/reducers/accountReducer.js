// import {depositAction, withdrawAction} from "../actions/accountActions";
// import {putQuoteAction, quoteErrorAction, quotePendingAction} from "../actions/quoteAction";
import {createReducer} from "@reduxjs/toolkit";
import {depositAction, withdrawAction} from "../actions/accountActions";
import {putQuoteAction, quoteErrorAction, quotePendingAction} from "../actions/quoteAction";

const initialState = {balance: 10, quote: 'Future is coming...'};

// 1 solution - Map object notation
// export const accountReducer = createReducer(initialState, {
//     [depositAction]: (state, action) => {
//         state.balance += action.payload;
//     },
//     [withdrawAction]: (state, action) => {
//         let res = state.balance - action.payload;
//         state.balance = res < 0 ? state.balance : res;
//     },
//     [putQuoteAction]: (state, action) => {
//         state.quote = action.payload;
//     },
//     [quotePendingAction]: (state, action) => {
//         state.quote = action.payload;
//     },
//     [quoteErrorAction]: (state, action) => {
//         state.quote = action.payload;
//     }
// });

//2 solution - Builder notation
export const accountReducer = createReducer(initialState, builder => {
builder
    .addCase(depositAction, (state, action) => {
        state.balance += action.payload;
    })
    .addCase(withdrawAction,(state, action) => {
        let res = state.balance - action.payload;
        state.balance = res < 0 ? state.balance : res;
    })
    .addCase(putQuoteAction, (state, action) => {
        state.quote = action.payload;
    })
    .addCase(quotePendingAction, (state, action) => {
        state.quote = action.payload;
    })
    .addCase(quoteErrorAction, (state, action) => {
        state.quote = action.payload;
    })
});