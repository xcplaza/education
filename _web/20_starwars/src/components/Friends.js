import React from 'react';
import {friendsArray} from "../utils/constans";
import Friend from "./Friend";

const Friends = () => {
    return (
        <section className="float-end w-50 row border border-light rounded-bottom-3 mx-1">
            <h3 className="col-12 text-center text-uppercase">friends</h3>
            {friendsArray.map((item, index) => <Friend key={index} image={item} pos={index + 1}/>)}
        </section>
    );
};

export default Friends;