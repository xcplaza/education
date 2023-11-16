import React from 'react';
import {useDispatch, useSelector} from "react-redux";
import {changeAvatarAction, changeNameAction} from "../redux/actions/userActions";

const UserAvatar = (props) => {
    const user = useSelector(state => state.user);
    const dispatcher = useDispatch();

    return <img className={`user-avatar ${props.size}`} src={user.avatar} alt={user.name}
                onClick={() => {
                    let avatar = prompt('Enter new avatar url')
                    dispatcher(changeAvatarAction(avatar));
                }}
                onContextMenu={event => {
                    event.preventDefault();
                    let name = prompt('Enter new nickname')
                    dispatcher(changeNameAction(name));
                }}/>;
};

export default UserAvatar;