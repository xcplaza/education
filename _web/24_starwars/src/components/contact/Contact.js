import React, {Component, useEffect, useState} from 'react';
import style from './contact.module.css';
import {base_url, period} from "../../utils/constants";


const Contact = () =>
{
    const [dataPlanets, setDataPlanets] = useState ({planets: ['wait....']})

    useEffect(() => {
        let planetsFromStorage = JSON.parse(localStorage.getItem('planetsKey'));
        if(!planetsFromStorage || (new Date () - planetsFromStorage.time)> period ) {
            fetch(`${base_url}/planets`)
                .then(response => response.json())
                .then(data => data.map(item => item.name))
                .then(names => {
                    setDataPlanets({planets: names})
                    let planetsData = {planets: names, time: new Date()}
                    localStorage.setItem('planetsKey', JSON.stringify(planetsData));
                })}
        else{
            setDataPlanets({planets: planetsFromStorage.planets})
        }
    }, []);

        return (
            <div className="container">
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