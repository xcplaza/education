import React, {useContext} from 'react';
import {friendsArray} from "../utils/constants";
import {SWContext} from "../utils/contex";


const Hero = () => {
    const {hero} = useContext(SWContext);
    return (
        <section className="float-start w-25 my-1 mx-3">
            <img src={friendsArray[hero].img} alt={friendsArray[hero].name} className="w-100"/>
        </section>
    );
};

export default Hero;