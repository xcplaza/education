import React from 'react';
import style from './footer.module.css';

const Footer = () =>
{
    return (
        <footer className="rounded-bottom-4">
            <div
                className="nav-item btn btn-danger border border-light rounded-pill common-button mx-1 position-relative button">
                <p>Send me an <span className={style.email}>email</span></p>
            </div>
        </footer>
    );
};

export default Footer;