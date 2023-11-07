import React from 'react';

const Hero = () => {
    return (
        <section className="float-start w-25 my-1 mx-3">
            <img src={require("../images/main.jpg")} alt="Hero" className="w-100"/>
        </section>
    );
};

export default Hero;