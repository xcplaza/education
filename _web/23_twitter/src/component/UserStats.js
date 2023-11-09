import React from 'react';
import UserAvatar from "./UserAvatar";
import {TwitterContext} from "../utils/TwitterContext";

const UserStats = () => {
    return (
        <TwitterContext.Consumer>
            {value => (
                <div className={'user-stats'}>
                    <div>
                        <UserAvatar/>
                        {value.user.name}
                    </div>
                    <div className={'stats'}>
                        <div>Followers: {value.stats.followers}</div>
                        <div>Followings: {value.stats.following}</div>
                    </div>
                </div>
            )}
        </TwitterContext.Consumer>
    );
};

export default UserStats;