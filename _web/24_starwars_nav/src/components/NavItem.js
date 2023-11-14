import React, {useContext} from 'react';
import {SWContext} from "../utils/contex";
import {Link} from "react-router-dom";
import hero from "./Hero";

const NavItem = ({text, hero}) => //let {text} = props -> let text = props.text
{

    let route = `/${text.route}`;
    if (text.route === 'home' || text.route === 'about_me')
        route += `/${hero}`;
    return (<Link to={route} className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1">{text.title}</Link>)
};

export default NavItem;