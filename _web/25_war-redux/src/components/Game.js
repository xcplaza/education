import React, {useEffect, useRef, useState} from 'react';
import {result, cards} from "../constants";
import {useDispatch, useSelector} from "react-redux";
import {changePageAction, setCompWinsAction, setPlayerWinsAction} from "../redux/gameActions";

const Game = () =>
{
    const [compCard, setCompCard] = useState('');
    const [playerCard, setPlayerCard] = useState('');

    let playerWins = useRef(0);
    let compWins = useRef(0);
    const compCards = useRef([]);
    const playerCards = useRef([]);

    const dispatch = useDispatch()
    const name = useSelector(state => state.name)


    useEffect(() =>
    {
        const deck = [...cards];
        for (let i = deck.length - 1; i > 0; i--)
        {
            deck.sort(() => Math.random() - 0.5);
        }
        compCards.current = deck.slice(0, deck.length / 2);
        playerCards.current = deck.slice(deck.length / 2, deck.length);
        handleClickNext();
    }, []);

    const handleClickNext = () =>
    {
        if (compCards.current.length)
        {
            const compCard = compCards.current.pop();
            const playerCard = playerCards.current.pop();
            if (compCard.value > playerCard.value)
                compWins.current++;
            if (compCard.value < playerCard.value)
               playerWins.current++;
            setCompCard(compCard);
            setPlayerCard(playerCard);
        }
        else
        {
            dispatch(changePageAction(result))
            dispatch(setCompWinsAction(compWins.current))
            dispatch(setPlayerWinsAction(playerWins.current))
        }
    }

    return (<div>
        <h1 className={'players computer'}>Computer</h1>
        <div className={'playerDeck'}>
            <img src={compCard.src}/>
        </div>
        <div className={'playerDeck'}>
            <img src={playerCard.src}/>
        </div>
        <h1 className={'players you'}>{name}</h1>
        <button className={'ingameButton'} onClick={handleClickNext}>Next</button>
    </div>)
}

export default Game;
