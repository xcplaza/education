import React, {useEffect, useState} from 'react';
import {baseURL} from "../utils/constans";

const FarGalaxy = () => {
    const [data, setData] = useState({
        isLoading: true,
        filmTitle: null,
        filmData: null
    });

    useEffect(() => {
        const filmTitleFromStorage = sessionStorage.getItem('filmTitle');
        const filmDataFromStorage = sessionStorage.getItem('filmData');

        if (filmDataFromStorage && filmTitleFromStorage) {
            setData({
                isLoading: false,
                filmTitle: filmTitleFromStorage,
                filmData: filmDataFromStorage
            })
        } else {
            const episode = Math.floor(Math.random() * 6) + 1;
            fetch(`${baseURL}/films/${episode}`)
                .then(r => r.json())
                .then(data => {
                    setData({
                        isLoading: false,
                        filmTitle: data.title,
                        filmData: data.opening_crawl
                    })
                    sessionStorage.setItem('filmData', data.opening_crawl);
                    sessionStorage.setItem('filmTitle', data.title);
                })
        }
        // return console.log('unmount'); - after unmount useEffect
    }, []);

    if (data.isLoading)
        return <p className={'farGalaxy'}>Loading..........</p>
    else
        return (
            <div>
                <h1 style={{
                    textTransform: 'uppercase',
                    textAllign: 'center',
                    color: 'darkgoldenrod'
                }}>{data.filmTitle}</h1>
                <p className={'farGalaxy'}>{data.filmData}</p>
            </div>
        );
}

export default FarGalaxy;