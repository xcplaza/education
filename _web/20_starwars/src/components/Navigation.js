import React from 'react';
import NavItem from "./NavItem";
import {navItemsArray} from "../utils/constans";

const Navigation = () => {
    return (
        <nav>
            <ul className="nav fixed-top mt-1 ms-5">
                {navItemsArray.map(item => <NavItem key={item} text={item}/>)}
            </ul>
        </nav>
    );
};

export default Navigation;