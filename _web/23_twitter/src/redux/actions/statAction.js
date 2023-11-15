export const CHANGE_STATS = 'CHANGE_STATS'
export const changeStatsAction = (statsType, sum) => ({
    type: CHANGE_STATS,
    payload: {statsType, sum}
});