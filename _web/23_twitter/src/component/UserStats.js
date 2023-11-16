import React, {useState} from 'react';
import UserAvatar from "./UserAvatar";
import {useDispatch, useSelector} from "react-redux";
import {changeStatsAction} from "../redux/actions/statAction";

const UserStats = () =>
{
    // const value = useContext(TwitterContext);
    const {user, stats} = useSelector(state => state);
    // OR
    // const user = useSelector(state => state.user);
    // const stats = useSelector(state => state.stats);
    
    const dispatch = useDispatch();

    return (<div className={'user-stats'}>
        <div>
            <UserAvatar/>
            {user.name}
        </div>
        <div className='stats'>
            <div onClick={() => dispatch(changeStatsAction('followers', 1))}
                 onContextMenu={e =>
                 {
                     e.preventDefault();
                     dispatch(changeStatsAction('followers', -1));
                 }}>Followers: {stats.followers}
            </div>
            <div onClick={() => dispatch(changeStatsAction('following', 1))}
                 onContextMenu={(e) =>
                 {
                     e.preventDefault();
                     dispatch(changeStatsAction('following', -1));
                 }}>Following: {stats.following}
            </div>
        </div>
    </div>);
};

export default UserStats;