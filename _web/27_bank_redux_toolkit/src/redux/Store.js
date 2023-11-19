export const createStore = (initialState, red) => {
    let state = initialState;
    let reducer = red;
    let subscribers = [];
    const getState = () => state;
    const dispatch = action => {
        state = reducer(state, action);
        subscribers.forEach(callback => callback());
    }
    const subscribe = callback => {
        subscribers.push(callback);
        return () => subscribers = subscribers.filter(fn => fn !== callback);
    }

    return {getState, dispatch, subscribe};

}