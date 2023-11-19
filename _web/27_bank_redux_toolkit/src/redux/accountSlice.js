import {createSlice} from "@reduxjs/toolkit";

const accountSlice = createSlice({
    name: 'bank',
    initialState: {balance: 10, quote: 'Future is coming...'},
    reducers: {
        depositAction(state, action) {
            state.balance += action.payload;
        },
        withdrawAction(state, action) {
            let res = state.balance - action.payload;
            state.balance = res < 0 ? state.balance : res;
        },
        putQuoteAction(state, action) {
            state.quote = action.payload;
        },
        quotePendingAction(state, action) {
            state.quote = action.payload;
        },
        quoteErrorAction(state, action) {
            state.quote = action.payload;
        }
    }
});

export const {
    depositAction, withdrawAction,
    putQuoteAction, quotePendingAction,
    quoteErrorAction
} = accountSlice.actions
export default accountSlice.reducer