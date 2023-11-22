import {configureStore, ThunkAction, Action} from '@reduxjs/toolkit';
import account from '../features/accountSlice';

export const store = configureStore({
    reducer: {account},
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
    ReturnType,
    RootState,
    unknown,
    Action<string>
>;
