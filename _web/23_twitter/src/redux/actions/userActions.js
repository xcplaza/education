export const CHANGE_AVATAR = 'CHANGE_AVATAR'
export const CHANGE_NAME = 'CHANGE_NAME'

export const changeAvatarAction = url => ({
    type: CHANGE_AVATAR,
    payload: url
});

export const changeNameAction = name => ({
    type: CHANGE_NAME,
    payload: name
});