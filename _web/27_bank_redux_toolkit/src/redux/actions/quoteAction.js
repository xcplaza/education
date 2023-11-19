import {createAction} from "@reduxjs/toolkit";
import {putQuoteAction, quoteErrorAction, quotePendingAction} from "../accountSlice";
// export const quotePendingAction = createAction('QUOTE_PENDING');
// export const quoteErrorAction = createAction('QUOTE_ERROR');
// export const putQuoteAction = createAction('PUT_QUOTE');

export const getQuoteAction = () => {
    return dispatch => {
        dispatch(quotePendingAction('Loading......'));
        fetch('https://api.kanye.rest/')
            .then(resp => resp.json())
            .then(data => dispatch(putQuoteAction(data.quote)))
            .catch(() => dispatch(quoteErrorAction('Oooops, 404 error')))
    }
}