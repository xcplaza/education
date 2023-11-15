import {createStore} from "redux";
import {twitterReducer} from "./reducers/twitterReducer";

let initialState =
    {
        user:
            {
                avatar: 'https://oir.mobi/uploads/posts/2021-04/1619701495_42-oir_mobi-p-sonnii-kotik-zhivotnie-krasivo-foto-43.jpg',
                name: 'Pussy cat'
            },
        stats:
            {
                followers: 10,
                following: 1
            }
    }

export const store = createStore(twitterReducer, initialState);