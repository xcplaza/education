import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {useState} from "react";
import {defaultHero} from "./utils/constants";

const App = () => {
    const [hero, setHero] = useState(defaultHero)
    return (
        <div className="container-fluid">
            <Header hero={hero}/>
            <Main setHero={setHero} hero={hero}/>
            <Footer/>
        </div>
    );

}

export default App;
