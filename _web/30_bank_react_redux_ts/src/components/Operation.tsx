import React, {useState} from 'react';
import {depositAction, withdrawAction} from "../features/accountSlice";
import {getQuoteAction} from "../features/quoteAction";
import {useAppDispatch} from "../app/hooks";

const Operation = () => {
    const [sum, setSum] = useState(0);
    const dispatch = useAppDispatch();

    return (
        <div className={'container'}>
            <div className={'d-flex justify-content-center'}>
                <button onClick={() => dispatch(withdrawAction(sum))} className={'btn btn-primary btn-lg'}>Withdraw
                </button>
                <input type={"number"} min={0} value={sum} onChange={e =>
                    setSum(e.target.value.includes('-') ? 0 : +e.target.value)}
                       className={'form-control-lg text-center'}/>
                <button onClick={() => dispatch(depositAction(sum))} className={'btn btn-primary btn-lg'}>Deposit
                </button>
            </div>
            <div className={'d-flex justify-content-center'}>
                <button className={'btn btn-primary btn-lg'} onClick={() => dispatch(getQuoteAction())}>Get quote</button>
            </div>
        </div>
    );
};

export default Operation;