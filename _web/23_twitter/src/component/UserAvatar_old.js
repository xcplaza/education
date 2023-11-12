import React, {useContext, useState} from 'react';
import {TwitterContext} from "../utils/TwitterContext";

const UserAvatar = () => {
    const value = useContext(TwitterContext)

    return <TwitterContext.Consumer>
        {value => <img className={'user-avatar'} src={value.user.avatar} alt={value.user.name} onClick={() => {
            let input = prompt('Enter new avatar');
            value.changeAvatar(input);
        }}/>}
    </TwitterContext.Consumer>
};

export default UserAvatar;