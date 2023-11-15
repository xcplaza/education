export const DEPOSIT = 'DEPOSIT';
export const WITHDRAW = 'WITHDRAW'

export const depositAction = sum => ({
    type: DEPOSIT,
    payload: sum
});

export const withdrawAction = sum => ({
    type: WITHDRAW,
    payload: sum
})