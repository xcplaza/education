import React from 'react';
import {characters, friendsArray} from "../utils/constants";
import Friend from "./Friend";

const Friends = ({hero}) => {
    return (
        <section className="float-end w-50 row border border-light rounded-bottom-3 mx-1">
            <h3 className="col-12 text-center text-uppercase">friends</h3>
            {characters.filter(item => item !== hero).map((item, index) => <Friend key={index} data={item} pos={index + 1}/>)}
        </section>
    );
};

export default Friends;