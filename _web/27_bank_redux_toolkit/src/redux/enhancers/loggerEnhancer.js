// export const loggerEnhancer = function (store) {
//     return function (nextFn) {
//         return function (action) {
//             // do something with action
//             return nextFn (action);
//         }
//     }
// }

// OR
export const loggerEnhancer = store => nextFn => action => {
    console.log(`Type of action: ${action.type}, Payload: ${action.payload}, Old state: ${JSON.stringify(store.getState())}`)
    return nextFn(action);
}
