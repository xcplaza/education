import React, {useContext} from 'react';
import Navigation from "./Navigation";
import {friendsArray} from "../utils/constants";
import {SWContext} from "../utils/contex";

const Header = () =>
{
    const {hero} = useContext(SWContext);
    return (
        <header className="rounded-top-4">
            <Navigation/>
            <h1 className="text-center fs-1 py-5">{friendsArray[hero].name}</h1>
        </header>
    );
};

export default Header;