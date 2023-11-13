import React, {useContext} from 'react';
import {SWContext} from "../utils/contex";
import {Link} from "react-router-dom";

const NavItem = ({text}) => //let {text} = props -> let text = props.text
{

    return <Link to={`/${text.route}`}
                 className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1">{text.title}
    </Link>
};

export default NavItem;