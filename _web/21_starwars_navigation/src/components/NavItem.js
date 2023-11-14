import React, {useContext} from 'react';
import {SWContext} from "../utils/contex";

const NavItem = ({text}) => //let {text} = props -> let text = props.text
{

    return <li className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1"
            onClick={() => window.location.hash = `#/${text.route}`}>{text.title}</li>};

export default NavItem;