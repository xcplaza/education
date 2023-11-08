import React from 'react';

const NavItem = ({text, changePage}) => {   //let text = props.text
    return <li className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1"
               onClick={() => changePage(text)}>{text}</li>
};

export default NavItem;