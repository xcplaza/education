import React, {useEffect} from 'react';
import Hero from "./Hero";
import Friends from "./Friends";
import FarGalaxy from "./FarGalaxy";
import {characters, defaultHero} from "../utils/constants";

const Home = (props) => {
    useEffect(() => {
        let key = props.match.params.heroId;
        if (!characters.includes(key))
            key = defaultHero;
        props.setHero(key);
    }, [props]);

    return (
        <main className="clearfix">
            <Hero hero={props.hero}/>
            <Friends hero={props.hero}/>
            <FarGalaxy/>
        </main>
    );
};

export default Home;