import React from 'react';
import {SWContext} from "../utils/context";

const NavItem = ({text}) => {   //let text = props.text
    return <SWContext.Consumer>
        {value => <li className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1"
                      onClick={() => value.changePage(text)}>{text}</li>}
    </SWContext.Consumer>
};

export default NavItem;