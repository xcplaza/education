import React from 'react';
import {friendsArray} from "../utils/constants";

const Hero = (props) =>
{
    return (
        <section className="float-start w-25 my-1 mx-3">
            <img src={friendsArray[props.hero].img} alt={friendsArray[props.hero].name} className="w-100"/>
        </section>
    );
};

export default Hero;