import React from 'react';

const NavItem = ({text}) => {   //let text = props.text
    return <li className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1">{text}</li>
};

export default NavItem;