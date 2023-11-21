import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {useState} from "react";
import {defaultHero} from "./utils/constants";
import {SWContext} from "./utils/contex";

const App = () => {
    const [hero, setHero] = useState(defaultHero)
    return (
        <div className="container-fluid">
            <SWContext.Provider value={{hero, changeHero: setHero}}>
                <Header/>
                <Main/>
                <Footer/>
            </SWContext.Provider>
        </div>
    );

}

export default App;
