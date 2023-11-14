import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {navItemsArray} from "./utils/constants";
import {SWContext} from "./utils/contex";
import {useEffect, useState} from "react";

const App = () =>
{
    const getItemByRoute = () =>
    {
        const route = window.location.hash.substring(2);
        return navItemsArray.find(item => item.route === route) || navItemsArray[0];
    }

    const [page, setPage] = useState(getItemByRoute());

    useEffect(() => {
        window.addEventListener('hashchange', () =>
        {
            const page = getItemByRoute();
            setPage(page);
        })
    }, []);

  const  changePage = page => setPage(page);



        return(

            <div className="container-fluid">
                <SWContext.Provider value={{
                    page,
                    changePage
                }}>
                    <Header/>
                    <Main/>
                </SWContext.Provider>
                <Footer/>
            </div>
        );

}

export default App;
