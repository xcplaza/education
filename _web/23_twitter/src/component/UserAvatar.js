import React, { useState } from 'react';
import { TwitterContext } from "../utils/TwitterContext";

const UserAvatar = () => {
    const [avatar, setAvatar] = useState('');

    const handleClick = () => {
        const input = document.createElement('input');
        input.type = 'file';
        // input.accept = 'image/*';

        input.onchange = (event) => {
            const file = event.target.files[0];
            const reader = new FileReader();

            reader.onload = (e) => {
                // Update the avatar here
                setAvatar(e.target.result);
            };
            reader.readAsDataURL(file);
        };
        input.click();
    };

    return (
        <TwitterContext.Consumer>
            {value => (
                <img
                    className={'user-avatar'}
                    src={avatar || value.user.avatar}
                    alt={value.user.name}
                    onClick={handleClick}
                />
            )}
        </TwitterContext.Consumer>
    );
};

export default UserAvatar;




//import React from 'react';
// import {TwitterContext} from "../utils/TwitterContext";
//
// const UserAvatar = () => {
//     return <TwitterContext.Consumer>
//         {value => <img className={'user-avatar'} src={value.user.avatar} alt={value.user.name}/>}
//     </TwitterContext.Consumer>
// };
//
// export default UserAvatar;