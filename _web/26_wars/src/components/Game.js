import React, {useState} from 'react';
import Result from './Result';

const Game = ({playerName, playerCards, computerCards}) => {
    const [score, setScore] = useState(0);
    const [round, setRound] = useState(0);
    const [gameOver, setGameOver] = useState(false);
    const [wins, setWins] = useState(0);
    const [losses, setLosses] = useState(0);

    const compareCards = () => {
        if (playerCards && computerCards && round < playerCards.length && round < computerCards.length) {
            const playerCardValue = playerCards[round].value;
            const computerCardValue = computerCards[round].value;

            if (playerCardValue > computerCardValue) {
                setScore(score + 1);
            } else if (playerCardValue < computerCardValue) {
                setLosses(losses + 1);
            } else {
            }

            setRound(round + 1);

            if (round === playerCards.length - 1) {
                setGameOver(true);
                setWins(score);
            }
        }
    };

    const playAgain = () => {
        // Сбросить состояние для новой игры
        setScore(0);
        setRound(0);
        setGameOver(false);
        setWins(0);
        setLosses(0);
    };

    return (
        <div className={'playerForm'}>
            {gameOver ? (
                <Result
                    playerName={playerName}
                    wins={wins}
                    losses={losses}
                    onPlayAgain={playAgain}
                />
            ) : (
                <>
                    <h1 className={'computer'}>Computer</h1>
                    <div className={'img'}>
                        {playerCards && computerCards && (
                            <>
                                <img className={'playerDeck'} src={process.env.PUBLIC_URL + playerCards[round].src}
                                     alt={`Player Card ${round}`}/>
                                <img className={'playerDeck'} src={process.env.PUBLIC_URL + computerCards[round].src}
                                     alt={`Computer Card ${round}`}/>
                            </>
                        )}
                    </div>
                    <h3 className={'players'}>{playerName}</h3>
                    <button className={'ingameButton'} onClick={compareCards}>Next</button>
                </>
            )}
        </div>
    );
};

export default Game;
