import React, {useEffect, useState} from 'react';
import {baseURL, period} from "../../utils/constans";
import style from "./about_me.module.css";

const AboutMe = () => {
    const [hero, setHero] = useState();

    useEffect(() => {
        let heroFromStorage = JSON.parse(sessionStorage.getItem('heroKey')); // get key hero + data => parse to object
        if (!heroFromStorage || (new Date() - heroFromStorage.time) > period) {
            fetch(`${baseURL}/peoples/1`)
                .then(response => response.json())
                .then(data => {
                    let info = {
                        "birth_year": data.birth_year,
                        "eye_color": data.eye_color,
                        "gender": data.gender,
                        "hair_color": data.hair_color,
                        "height": data.height,
                        "mass": data.mass,
                        "name": data.name,
                        "skin_color": data.skin_color
                    }
                    setHero(info);
                    let heroData = {
                        info,
                        time: new Date()
                    }
                    sessionStorage.setItem('heroKey', JSON.stringify(heroData)); //set data + data hero
                });
        } else {
            setHero(heroFromStorage.info);
        }
    }, []);

        return (
            <React.Fragment>
                {hero && <div className={`farGalaxy ${style.hero_box}`}>
                    <p><span className={style.hero_title}>Name: </span>{hero.name}</p>
                    <p><span className={style.hero_title}>Gender: </span>{hero.gender}</p>
                    <p><span className={style.hero_title}>Birth year: </span>{hero.birth_year}</p>
                    <p><span className={style.hero_title}>Eye color: </span>{hero.eye_color}</p>
                    <p><span className={style.hero_title}>Hair color: </span>{hero.hair_color}</p>
                    <p><span className={style.hero_title}>Skin color: </span>{hero.skin_color}</p>
                    <p><span className={style.hero_title}>Height: </span>{hero.height}</p>
                    <p><span className={style.hero_title}>Mass: </span>{hero.mass}</p>
                </div>}
            </React.Fragment>
        );
}

export default AboutMe;