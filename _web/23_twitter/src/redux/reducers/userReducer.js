import {CHANGE_AVATAR, CHANGE_NAME} from "../actions/userActions";

const state = {
    avatar: 'https://oir.mobi/uploads/posts/2021-04/1619701495_42-oir_mobi-p-sonnii-kotik-zhivotnie-krasivo-foto-43.jpg',
    name: 'Pussy cat'
};
export const userReducer = (user = state, action) => {
    switch (action.type) {
        case CHANGE_NAME:
            return {...user, name: action.payload || user.name};
        case CHANGE_AVATAR:
            return {...user, avatar: action.payload || user.avatar};
        default:
            return user;
    }

}