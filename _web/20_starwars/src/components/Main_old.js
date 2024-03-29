import React, {useContext} from 'react';
import {navItemsArray} from "../utils/constans";
import AboutMe from "./about_me/AboutMe";
import StarWars from "./StarWars";
import Config from "bootstrap/js/src/util/config";
import Home from "./Home";
import Contact from "./contact/Contact";
import {SWContext} from "../utils/context";

const Main = () => {
    const value = useContext(SWContext)

    switch (value.page) {
        case navItemsArray[1]:
            return <AboutMe/>
        case navItemsArray[2]:
            return <StarWars/>
        case navItemsArray[3]:
            return <Contact/>
        default:
            return <Home/>
    }
};

export default Main;