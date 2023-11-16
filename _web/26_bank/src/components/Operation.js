import React, {useState} from 'react';
import {depositAction, withdrawAction} from "../redux/actions/accountActions";
import {useDispatch} from "react-redux";
import {getQuoteAction, putQuoteAction} from "../redux/actions/quoteAction";

const Operation = () => {
    const [sum, setSum] = useState(0);
    const dispatch = useDispatch();

    // const handleClickQuote = () => {
    //     fetch('https://api.kanye.rest/')
    //         .then(resp => resp.json())
    //         .then(data => dispatch(putQuoteAction(data.quote)))
    // };
    return (
        <div className={'container'}>
            <div className={'d-flex justify-content-center'}>
                <button onClick={() => dispatch(withdrawAction(sum))} className={'btn btn-primary btn-lg'}>Withdraw
                </button>
                <input type={"number"} min={0} value={sum} onChange={e => setSum(+e.target.value)}
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