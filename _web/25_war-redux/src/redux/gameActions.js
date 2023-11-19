export const SET_NAME = 'SET_NAME';
export const CHANGE_PAGE = 'CHANGE_PAGE';
export const SET_COMP_WINS = 'SET_COMP_WINS';
export const SET_PLAYER_WINS = 'SET_PLAYER_WINS';

export const  setNameAction = name =>
    ({
        type: SET_NAME,
        payload: name
    });

export const  changePageAction = page =>
    ({
        type: CHANGE_PAGE,
        payload: page
    });

export const  setCompWinsAction = compWins =>
    ({
        type: SET_COMP_WINS,
        payload: compWins
    });

export const  setPlayerWinsAction = playerWins =>
    ({
        type: SET_PLAYER_WINS,
        payload: playerWins
    });
