import React from 'react';
import {Route, Routes} from "react-router-dom";
import {navItemsArray} from "../utils/constants";
import Home from "./Home";
import AboutMe from "./about_me/AboutMe";
import StarWars from "./StarWars";
import Contact from "./contact/Contact";
import ErrorPage from "./ErrorPage";


const Main = ({setHero, hero}) => {
    return (
        <Routes>
            {/*{['/', `${navItemsArray[0].route}`, `${navItemsArray[0].route}/:heroId`].map(path => <Route path={path} key={path} element={<Home setHero={setHero} hero={hero}/>}/>)}*/}
            <Route path={'/'} element={<Home setHero={setHero} hero={hero}/>}>
                <Route path={`${navItemsArray[0].route}`} element={<Home setHero={setHero} hero={hero}/>}>
                    <Route path={':heroId'} element={<Home setHero={setHero} hero={hero}/>}/>
                </Route>

            </Route>
            <Route path={`${navItemsArray[1].route}`} element={<AboutMe setHero={setHero}/>}/>
            <Route path={`${navItemsArray[1].route}/:heroId`} element={<AboutMe setHero={setHero}/>}/>
            <Route path={`${navItemsArray[2].route}`} element={<StarWars/>} exact/>
            <Route path={`${navItemsArray[3].route}`} element={<Contact/>} exact/>
            <Route path={'*'} element={<ErrorPage/>}/>
        </Routes>
    )
};

export default Main;