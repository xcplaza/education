import React from 'react';
import {Route, Switch} from "react-router-dom";
import {navItemsArray} from "../utils/constants";
import Home from "./Home";
import AboutMe from "./about_me/AboutMe";
import StarWars from "./StarWars";
import Contact from "./contact/Contact";
import ErrorPage from "./ErrorPage";


const Main = ({setHero}) => {
    return (
        <Switch>
            <Route path={['/', `/${navItemsArray[0].route}`, `/${navItemsArray[0].route}/:heroId`]} component={Home} exact/>
            {/*<Route path={[`/${navItemsArray[1].route}`, `/${navItemsArray[1].route}/:heroId`]} component={AboutMe} exact/>*/}
            <Route path={[`/${navItemsArray[1].route}`, `/${navItemsArray[1].route}/:heroId`]} exact render={(routeProps) =><AboutMe {...routeProps} setHero={setHero}/>}/>
            <Route path={`/${navItemsArray[2].route}`} component={StarWars} exact/>
            <Route path={`/${navItemsArray[3].route}`} component={Contact} exact/>
            <Route component={ErrorPage}/>
        </Switch>
    )
};

export default Main;