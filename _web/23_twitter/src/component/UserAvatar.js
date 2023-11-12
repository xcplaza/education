import React, {useContext} from 'react';
import {TwitterContext} from "../utils/TwitterContext";

const UserAvatar = (props) =>
{
    const value = useContext(TwitterContext);
    return <img className={`user-avatar ${props.size}`} src={value.user.avatar} alt={value.user.name}
                onClick={() => value.changeAvatar(prompt('Enter new avatar url'))}
                onContextMenu={event =>
                {
                    event.preventDefault();
                    value.changeName(prompt('Enter new nickname'));
                }}/>;
};

export default UserAvatar;