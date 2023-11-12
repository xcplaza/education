import React, {useContext} from 'react';
import UserAvatar from "./UserAvatar";
import {TwittexContext} from "../utils/TwittexContext";

const UserStats = () => {
    const value = useContext(TwittexContext)
    return <div className={'user-stats'}>
        <div>
            <UserAvatar/>
            {value.user.name}
        </div>
        <div className='stats'>
            <div onClick={() => value.changeStats('followers', 1)} onContextMenu={(e) => {
                e.preventDefault();
                value.changeStats('followers', -1);
            }}>Followers: {value.stats.followers}</div>
            <div onClick={() => value.changeStats('following', 1)} onContextMenu={(e) => {
                e.preventDefault();
                value.changeStats('following', -1);
            }}>Following: {value.stats.following}</div>
        </div>
    </div>
};

export default UserStats;