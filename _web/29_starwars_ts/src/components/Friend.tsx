import React from 'react';
import {friendsArray, navItemsArray} from "../utils/constants";
import {useNavigate} from "react-router-dom";

interface Props {
    data: string,
    pos: number
}

const Friend = ({data, pos}: Props) => {
    const navigate = useNavigate();
    let style = "col-4 p-1";
    if (pos === 7)
        style += ' bottom-left';
    else if (pos === 9)
        style += ' bottom-right';

    // return (<Link className={"col-4 p-1"} to={`/${navItemsArray[0].route}/${data}`}><img src={friendsArray[data].img} alt={friendsArray[data].name} className={style}/></Link>)
    return <img src={friendsArray[data].img} alt={friendsArray[data].name} className={style}
                onClick={() => navigate(`/${navItemsArray[0].route}/${data}`)}/>
};

export default Friend;