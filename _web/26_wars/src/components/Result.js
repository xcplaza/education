// Result.js
import React from 'react';

const Result = ({playerName, wins, losses, onPlayAgain}) => {
    const getResult = () => {
        if (wins > losses)
            return "You Win"
        if (wins < losses)
            return "You loss"
    }

    return (
        <div className={'result'}>
            <h2 className={'readyForWar'}>{getResult()}</h2>
            <p className={'players'}>{playerName} Wins: {wins}, Loss: {losses}</p>
            <button className={'ingameButton'} onClick={onPlayAgain}>Again?</button>
            {/* Дополнительные элементы и стили по вашему усмотрению */}
        </div>
    );
};

export default Result;
