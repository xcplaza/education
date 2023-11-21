import React, {useContext} from 'react';
import {Link} from "react-router-dom";
import hero from "./Hero";
import {Item} from "../utils/types";
import {SWContext} from "../utils/contex";

interface Props {
    text: Item
}

const NavItem = ({text}: Props) => //let {text} = props -> let text = props.text
{
    const {hero} = useContext(SWContext);
    let route = `/${text.route}`;
    if (text.route === 'home' || text.route === 'about_me')
        route += `/${hero}`;
    return (<Link to={route}
                  className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1">{text.title}</Link>)
};

export default NavItem;