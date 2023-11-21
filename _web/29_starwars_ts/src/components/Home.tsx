import React, {useContext, useEffect} from 'react';
import Hero from "./Hero";
import Friends from "./Friends";
import FarGalaxy from "./FarGalaxy";
import {characters, defaultHero} from "../utils/constants";
import {useParams} from "react-router-dom";
import {SWContext} from "../utils/contex";

const Home = () => {
    let {heroId} = useParams() as { heroId: string };
    const {changeHero} = useContext(SWContext);

    useEffect(() => {
        if (!characters.includes(heroId))
            heroId = defaultHero;
        changeHero(heroId);
    }, [heroId]);

    return (
        <main className="clearfix">
            <Hero/>
            <Friends/>
            <FarGalaxy/>
        </main>
    );
};

export default Home;