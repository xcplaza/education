import React, {Component, useEffect, useState} from 'react';
import {base_url} from "../utils/constants";


const FarGalaxy = () => {

    const [data, setData] = useState({
        isLoading: true,
        filmTitle: null,
        filmData: null
    });

    useEffect(() => {
        const filmTitleStorage = sessionStorage.getItem('filmTitle');
        const filmDataFromStorage = sessionStorage.getItem('filmData');

        if (filmTitleStorage && filmDataFromStorage) {
            setData({
                isLoading: false,
                filmTitle: filmTitleStorage,
                filmData: filmDataFromStorage
            })
        } else {
            const episode = Math.floor(Math.random() * 6) + 1;
            fetch(`${base_url}/films/${episode}`)
                .then(response => response.json())
                .then(data => {
                    setData(
                        {
                            isLoading: false,
                            filmTitle: data.title,
                            filmData: data.opening_crawl
                        });
                    sessionStorage.setItem('filmData', data.opening_crawl);
                    sessionStorage.setItem('filmTitle', data.title);
                }).catch(e => console.log(e))
        }

        return () => console.log ('finally')

    }, []);

    if (data.isLoading) {
        return (
            <p className={'farGalaxy'}> Loading.......</p>
        );
    } else {
        return (
            <div>
                <h1 style={{textTransform: 'uppercase', textAlign: 'center'}}>{data.filmTitle}</h1>
                <p className={'farGalaxy'}>{data.filmData}</p>
            </div>
        )
    }
}

export default FarGalaxy;