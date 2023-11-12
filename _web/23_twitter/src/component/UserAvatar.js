import React, {useContext} from 'react';
import {TwitterContext} from "../utils/TwitterContext";

const UserAvatar = ({size}) => {
    return <TwitterContext.Consumer>
        {value => <img className={`user-avatar ${size}`} src={value.user.avatar} alt={value.user.name}
                       onContextMenu={e => {
                           e.preventDefault();
                           prompt('Enter new name');
                       }
                       }/>}
    </TwitterContext.Consumer>
};

export default UserAvatar;