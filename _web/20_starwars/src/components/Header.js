import React from 'react';
import Navigation from "./Navigation";

const Header = ({changePage}) => {
    return (
        <header className="rounded-top-4">
            <Navigation changePage={changePage}/>
            <h1 className="text-center fs-1 py-5">Luke Skywalker</h1>
        </header>
    );
};

export default Header;