import React, {useContext} from 'react';
import {TwittexContext} from "../utils/TwittexContext";

const UserAvatar = () => {

    const value = useContext(TwittexContext);

    return (
        <img className={`user-avatar`}
             src={value.user.avatar}
             alt={value.user.name}
             onClick={() => value.changeAvatar(prompt('Enter new avatar url'))}
             onContextMenu={event => {
                 event.preventDefault();
                 value.changeName(prompt('Enter new nickname'))
             }}
        />
    )
}

    export default UserAvatar;