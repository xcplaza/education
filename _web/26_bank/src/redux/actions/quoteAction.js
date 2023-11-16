export const PUT_QUOTE = 'PUT_QUOTE';
export const QUOTE_PENDING = 'QUOTE_PENDING';
export const QUOTE_ERROR = 'QUOTE_ERROR';

export const quotePendingAction = () => ({
    type: QUOTE_PENDING,
    payload: 'Loading........'
});

export const quoteErrorAction = () => ({
    type: QUOTE_ERROR,
    payload: 'Ooopps error!'
})
export const putQuoteAction = quote => ({
    type: PUT_QUOTE,
    payload: quote
})

export const getQuoteAction = () => {
    return dispatch => {
        dispatch(quotePendingAction());
        fetch('https://api.kanye.rest/')
            .then(resp => resp.json())
            .then(data => dispatch(putQuoteAction(data.quote)))
            .catch(() => dispatch(quoteErrorAction()))
    }
}