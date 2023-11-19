import React, {useState} from 'react';
import {cards} from "../constants";
import Game from "./Game";

export const Start = () => {
    const [playerName, setPlayerName] = useState('');
    const [gameStarted, setGameStarted] = useState(false);
    const [playerCards, setPlayerCards] = useState([]);
    const [computerCards, setComputerCards] = useState([]);

    const createPlayer = () => {
        if (playerName === '') {
            alert('Please enter your name');
        } else {
            const player = {
                name: playerName,
                score: 0,
                cards: []
            };

            // Assign random cards to the player
            const randomCards = getRandomCards(cards, 26);
            player.cards = randomCards;

            // Transfer remaining cards to the computer's card array
            const remainingCards = cards.filter(card => !randomCards.includes(card));

            // Store player and computer card arrays in session storage
            sessionStorage.setItem('player', JSON.stringify(player));
            sessionStorage.setItem('computerCards', JSON.stringify(remainingCards));

            // Update state to indicate that the game has started
            setGameStarted(true);

            // Set the player and computer cards for Game component
            setPlayerCards(randomCards);
            setComputerCards(remainingCards);
        }
    };

    // Function to get random cards from the card array
    const getRandomCards = (cards, num) => {
        const shuffledCards = cards.sort(() => Math.random() - 0.5);
        return shuffledCards.slice(0, num);
    };

    return (
        <div className={'field'}>
            {gameStarted ? (
                <Game playerName={playerName} playerCards={playerCards} computerCards={computerCards}/>
            ) : (
                <>
                    <h2 className={'readyForWar'}>Ready for War</h2>
                    <div className={'playerForm'}><input
                        className={'playerName'}
                        placeholder={'Enter your name'}
                        value={playerName}
                        onChange={(e) => setPlayerName(e.target.value)}/>
                        <button className={'startButton'} onClick={createPlayer}>Start</button>
                    </div>
                </>
            )}
        </div>
    );
};
