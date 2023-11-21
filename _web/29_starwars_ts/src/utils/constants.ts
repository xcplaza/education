import friend1 from '../images/friend1.jpg';
import friend2 from '../images/friend2.jpg';
import friend3 from '../images/friend3.jpg';
import friend4 from '../images/friend4.jpg';
import friend5 from '../images/friend5.jpg';
import friend6 from '../images/friend6.jpg';
import friend7 from '../images/friend7.jpg';
import friend8 from '../images/friend8.jpg';
import friend9 from '../images/friend9.jpg';
import friend0 from "../images/main.jpg";
import {Friends, Item} from "./types";


export const base_url: string = 'https://sw-info-api.herokuapp.com/v1/';
export const friendsArray: Friends =
    {
        luke:
            {
                name: "Luke Skywalker",
                img: friend0,
                url: `${base_url}peoples/1`
            },
        r2d2:
            {
                name: "R2-D2",
                img: friend1,
                url: `${base_url}peoples/3`
            },
        c3po:
            {
                name: "C-3PO",
                img: friend2,
                url: `${base_url}peoples/2`
            },
        ewok:
            {
                name: "Wicket Systri Warrick",
                img: friend3,
                url: `${base_url}peoples/30`
            },
        chewbacca:
            {
                name: "Chewbacca",
                img: friend4,
                url: `${base_url}peoples/13`
            },
        han_solo:
            {
                name: "Han Solo",
                img: friend5,
                url: `${base_url}peoples/14`
            },
        leia:
            {
                name: "Leia Organa",
                img: friend6,
                url: `${base_url}peoples/5`
            },
        falcon:
            {
                name: "Millenium Falcon",
                img: friend7,
                url: `${base_url}transports/10`
            },
        obi_wan:
            {
                name: "Obi-Wan Kenobi",
                img: friend8,
                url: `${base_url}peoples/10`
            },
        yoda:
            {
                name: "Yoda",
                img: friend9,
                url: `${base_url}peoples/0`
            }
    }
export const characters = Object.keys(friendsArray);
export const defaultHero = characters[0];

export const navItemsArray: Item[] = [
    {title: 'Home', route: 'home'},
    {title: 'About me', route: 'about_me'},
    {title: 'Star wars', route: 'star_was'},
    {title: 'Contact', route: 'contact'},
];
export const title = 'title: The Empire Strikes Back episode: 5 release_date: 1980-05-17 opening\n' +
    '        crawl: It is\n' +
    '        a dark\n' +
    '        time for the Rebellion. Although the Death Star has been destroyed, Imperial troops have driven the\n' +
    '        Rebel\n' +
    '        forces\n' +
    '        from their hidden base and pursued them across the galaxy. Evading the dreaded Imperial Starfleet, a\n' +
    '        group of\n' +
    '        freedom fighters led by Luke Skywalker has established a new secret base on the remote ice world of\n' +
    '        Hoth. The\n' +
    '        evil lord Darth Vader, obsessed with finding young Skywalker, has dispatched thousands of remote\n' +
    '        probes into\n' +
    '        the\n' +
    '        far reaches of space.... ';

export const period = 1000 * 60 * 60 * 24 * 10;