import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {useState} from "react";
import {navItemsArray} from "./utils/constans";
import {SWContext} from "./utils/context";

const App = () => {
    const [page, setPage] = useState(navItemsArray[0]);

    const changePage = page => setPage(page);

    return (
        <div className="container-fluid">
            <SWContext.Provider value={{page, changePage}}>
                <Header/>
                <Main/>
            </SWContext.Provider>
            <Footer/>
        </div>
    );

}

export default App;
