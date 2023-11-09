import React from 'react';
import {TwitterContext} from "../utils/TwitterContext";

const UserAvatar = () => {
    return <TwitterContext.Consumer>
        {value => <img className={'user-avatar'} src={value.user.avatar} alt={value.user.name}/>}
    </TwitterContext.Consumer>
};

export default UserAvatar;