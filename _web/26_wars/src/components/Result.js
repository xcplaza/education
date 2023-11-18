// Result.js
import React from 'react';

const Result = ({ playerName, wins, losses, onPlayAgain }) => {
    return (
        <div className={'result'}>
            <h2 className={'readyForWar'}>Game Over!</h2>
            <p className={'players'}>{playerName} Wins: {wins}, Loss: {losses}</p>
            <button className={'ingameButton'} onClick={onPlayAgain}>Again?</button>
            {/* Дополнительные элементы и стили по вашему усмотрению */}
        </div>
    );
};

export default Result;
