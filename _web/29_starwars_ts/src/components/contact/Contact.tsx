import React, {useEffect, useState} from 'react';
import {base_url, period} from "../../utils/constants";
import {DataStore, DataPlanet} from "../../utils/types";
import style from "./contact.module.css";


const Contact = () =>
{
    const [dataPlanets, setDataPlanets] = useState ({planets: ['wait....']})

    useEffect(() => {
        let planetsFromStorage:DataStore = JSON.parse(localStorage.getItem('planetsKey') as string);
        if(!planetsFromStorage || (new Date ().valueOf() - planetsFromStorage.time)> period ) {
            fetch(`${base_url}/planets`)
                .then(response => response.json())
                .then((data: DataPlanet[]) => data.map(item => item.name))
                .then(names => {
                    setDataPlanets({planets: names})
                    let planetsData:DataStore = {
                        payload: names,
                        time: new Date().valueOf()}
                    localStorage.setItem('planetsKey', JSON.stringify(planetsData));
                })}
        else{
            setDataPlanets({planets: planetsFromStorage.payload})
        }
    }, []);

        return (
            <div className={style.container}>
                <form>
                    <label htmlFor="fname">First Name</label>
                    <input type="text" id="fname" name="firstname" placeholder="Your name.."/>
                    <label htmlFor="lname">Last Name</label>
                    <input type="text" id="lname" name="lastname" placeholder="Your last name.."/>
                    <label htmlFor="country">Country</label>
                    <select id="planets" name="planets">
                        {dataPlanets.planets.map((item, index) =>
                        <option value={item} key={index}>{item}</option>)}
                    </select>
                    <label htmlFor="subject">Subject</label>
                    <textarea id="subject" name="subject" placeholder="Write something.."
                              style={{height:'200px'}}></textarea>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
}

export default Contact;