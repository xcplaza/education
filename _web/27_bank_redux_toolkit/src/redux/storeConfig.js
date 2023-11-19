import {configureStore} from "@reduxjs/toolkit";
// import {accountReducer} from "./reducers/accountReducer";
import accountReducer from "../redux/accountSlice";

const store = configureStore({
    reducer: {account: accountReducer} //{account: accountReducer, quote: quoteReducer}
    // middleware: getDefaultMiddleware => getDefaultMiddleware.concat(logger)
})
export default store;