import React, {Component} from 'react';
import {baseURL} from "../../utils/constans";
import style from "./about_me.module.css";

class AboutMe extends Component {
    constructor(props) {
        super(props);
        this.state = {hero: null};
    }

    componentDidMount() {
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
                this.setState({hero: info});
            });
    }

    render() {
        return (
            <React.Fragment>
                {this.state.hero && <div className={`farGalaxy ${style.hero_box}`}>
                    <p><span className={style.hero_title}>Name: </span>{this.state.hero.name}</p>
                    <p><span className={style.hero_title}>Gender: </span>{this.state.hero.gender}</p>
                    <p><span className={style.hero_title}>Birth year: </span>{this.state.hero.birth_year}</p>
                    <p><span className={style.hero_title}>Eye color: </span>{this.state.hero.eye_color}</p>
                    <p><span className={style.hero_title}>Hair color: </span>{this.state.hero.hair_color}</p>
                    <p><span className={style.hero_title}>Skin color: </span>{this.state.hero.skin_color}</p>
                    <p><span className={style.hero_title}>Height: </span>{this.state.hero.height}</p>
                    <p><span className={style.hero_title}>Mass: </span>{this.state.hero.mass}</p>
                </div>}
            </React.Fragment>
        );
    }
}

export default AboutMe;