import React from 'react';
import {navItemsArray} from "../utils/constants";
import NavItem from "./NavItem";

const Navigation = () =>
{
    return (
        <nav>
            <ul className="nav fixed-top mt-1 ms-5">
                {navItemsArray.map(item => <NavItem key={item.route} text={item}/>)}
            </ul>
        </nav>
    );
};

export default Navigation;