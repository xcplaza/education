import React, {Component} from 'react';
import {baseURL} from "../utils/constans";

class FarGalaxy extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            filmTitle: null,
            filmData: null
        }
    }

    componentDidMount() {
        const filmTitleFromStorage = sessionStorage.getItem('filmTitle');
        const filmDataFromStorage = sessionStorage.getItem('filmData');

        if (filmDataFromStorage && filmTitleFromStorage) {
            this.setState({
                isLoading: false,
                filmTitle: filmTitleFromStorage,
                filmData: filmDataFromStorage
            })
        } else {
            const episode = Math.floor(Math.random() * 6) + 1;
            fetch(`${baseURL}/films/${episode}`)
                .then(r => r.json())
                .then(data => {
                    this.setState({
                        isLoading: false,
                        filmTitle: data.title,
                        filmData: data.opening_crawl
                    })
                    sessionStorage.setItem('filmData', data.opening_crawl);
                    sessionStorage.setItem('filmTitle', data.title);
                })
        }
    }

    render() {
        if (this.state.isLoading)
            return <p className={'farGalaxy'}>Loading..........</p>
        else
            return (
                <div>
                    <h1 style={{textTransform: 'uppercase', textAllign: 'center', color: 'darkgoldenrod'}}>{this.state.filmTitle}</h1>
                    <p className={'farGalaxy'}>{this.state.filmData}</p>
                </div>
            );
    }
}

export default FarGalaxy;