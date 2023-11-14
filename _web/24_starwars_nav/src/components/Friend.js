import React from 'react';
import {friendsArray, navItemsArray} from "../utils/constants";
import {Link} from "react-router-dom";

const Friend = ({data, pos}) =>
{
    let style = "w-100";
    if(pos === 7)
        style += ' bottom-left';
    else if(pos === 9)
        style += ' bottom-right';

    return (<Link className={"col-4 p-1"} to={`/${navItemsArray[0].route}/${data}`}><img src={friendsArray[data].img} alt={friendsArray[data].name} className={style}/></Link>)
};

export default Friend;