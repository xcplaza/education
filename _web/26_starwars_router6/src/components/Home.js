import React, {useEffect} from 'react';
import Hero from "./Hero";
import Friends from "./Friends";
import FarGalaxy from "./FarGalaxy";
import {characters, defaultHero} from "../utils/constants";
import {useParams} from "react-router-dom";
import hero from "./Hero";

const Home = (props) => {
    let {heroId} = useParams();

    useEffect(() => {
        if (!characters.includes(heroId))
            heroId = defaultHero;
        props.setHero(heroId);
    }, [heroId]);

    return (
        <main className="clearfix">
            <Hero hero={props.hero}/>
            <Friends hero={props.hero}/>
            <FarGalaxy/>
        </main>
    );
};

export default Home;