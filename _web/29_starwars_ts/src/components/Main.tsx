import React from 'react';
import {Route, Routes} from "react-router-dom";
import {navItemsArray} from "../utils/constants";
import Home from "./Home";
import AboutMe from "./about_me/AboutMe";
import StarWars from "./StarWars";
import Contact from "./contact/Contact";
import ErrorPage from "./ErrorPage";

const Main = () => {
    return (
        <Routes>
            <Route path={'/'} element={<Home/>}>
                <Route path={`${navItemsArray[0].route}`} element={<Home/>}>
                    <Route path={':heroId'} element={<Home/>}/>
                </Route>
            </Route>
            <Route path={`${navItemsArray[1].route}`} element={<AboutMe/>}/>
            <Route path={`${navItemsArray[1].route}/:heroId`} element={<AboutMe/>}/>
            <Route path={`${navItemsArray[2].route}`} element={<StarWars/>}/>
            <Route path={`${navItemsArray[3].route}`} element={<Contact/>}/>
            <Route path={'*'} element={<ErrorPage/>}/>
        </Routes>
    )
};

export default Main;