import React from 'react';

const Friend = ({image, pos}) => {
    let style = "col-4 p-1 shadow-none";
    if (pos === 7) {
        style += " bottom-left";
    } else if (pos === 9) {
        style += " bottom-right";
    }
    return <img src={image} alt="friends" className={style}/>
};

export default Friend;