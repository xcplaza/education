import React, {useContext} from 'react';
import {navItemsArray} from "../utils/constants";
import AboutMe from "./about_me/AboutMe";
import StarWars from "./StarWars";
import Contact from "./contact/Contact";
import Home from "./Home";
import {SWContext} from "../utils/contex";

const Main = () =>
{
const value = useContext(SWContext);

                    switch (value.page.route)
                    {
                        case navItemsArray[1].route: return <AboutMe/>
                        case navItemsArray[2].route: return <StarWars/>
                        case navItemsArray[3].route: return <Contact/>
                        default: return <Home/>
                    }
};

export default Main;