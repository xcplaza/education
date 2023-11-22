import React from 'react';
import {useAppSelector} from "../app/hooks";

const Balance = () => {
    const balance = useAppSelector(state => state.account.balance);
    const quote = useAppSelector(state => state.account.quote)

    return (
        <div>
            <h1 className={'text-center text-uppercase'}>My Bank</h1>
            <h4 className={'text-center text-uppercase'}><q>{quote}</q></h4>
            <h3 className={'text-center text-uppercase'}>Balance = {balance}</h3>
        </div>
    );

};

export default Balance;