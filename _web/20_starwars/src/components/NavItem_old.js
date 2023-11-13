import React, {useContext} from 'react';
import {SWContext} from "../utils/context";

const NavItem = ({text}) => {   //let text = props.text
    const value = useContext(SWContext);

    return <li className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1"
               onClick={() => value.changePage(text)}>{text}</li>
    // <a href={`#/${text.route}`}>{text.title}</a>
};

export default NavItem;