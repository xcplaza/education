import React, {Component} from 'react';
import {baseURL} from "../../utils/constans";
import style from './contact.module.css';
import data from "bootstrap/js/src/dom/data";

class Contact extends Component {
    constructor(props) {
        super(props);
        this.state = {planets: ['wait...']};
    }

    componentDidMount() {
        fetch(`${baseURL}/planets`)
            .then(r => r.json())
            // .then(data => this.setState({planets: data}))
            .then(data => data.map(item => item.name))
            .then(names => this.setState({planets: names}))
    }

    render() {
        return (


            <div className={style.container}>
                {/*<div>*/}
                <form>
                    <label htmlFor="fname">First Name</label>
                    <input type="text" id="fname" name="firstname" placeholder="Your name.."/>
                    <label htmlFor="lname">Last Name</label>
                    <input type="text" id="lname" name="lastname" placeholder="Your last name.."/>
                    <label htmlFor="country">Planets</label>
                    <select id="country" name="country">
                        {this.state.planets.map((item, index) => <option value={item} key={index}>{item}</option>)}
                    </select>
                    <label for="subject">Subject</label>
                    <textarea id="subject" name="subject" placeholder="Write something.."
                              style={{height: '200px'}}></textarea>
                    <input type="submit" value="Submit"/>
                </form>
            </div>

        );
    }
}


export default Contact;