import React, { useState } from 'react';
import UserAvatar from "./UserAvatar";
import { TwitterContext } from "../utils/TwitterContext";

function UserStats() {
    const [followers, setFollowers] = useState(0);
    const [followings, setFollowings] = useState(0);

    const handleIncrement = (target) => {
        if (target === 'followers') {
            setFollowers(followers + 1);
        } else if (target === 'followings') {
            setFollowings(followings + 1);
        }
    };

    const handleDecrement = (e, target) => {
        e.preventDefault(); // Предотвращаем стандартное контекстное меню
        if (target === 'followers') {
            setFollowers(followers - 1);
        } else if (target === 'followings') {
            setFollowings(followings - 1);
        }
    };

    return (
        <TwitterContext.Consumer>
            {value => (
                <div className={'user-stats'}>
                    <div><UserAvatar />{value.user.name}</div>
                    <div className={'stats'}>
                        <div onClick={() => handleIncrement('followers')} onContextMenu={(e) => handleDecrement(e, 'followers')}>Followers: {followers}</div>
                        <div onClick={() => handleIncrement('followings')} onContextMenu={(e) => handleDecrement(e, 'followings')}>Followings: {followings}</div>
                    </div>
                </div>
            )}
        </TwitterContext.Consumer>
    );
}

export default UserStats;
