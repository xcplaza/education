import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {Component} from "react";
import {navItemsArray} from "./utils/constans";
import {SWContext} from "./utils/context";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {ActivePage: navItemsArray["Home"]};
    }

    changePage = page => this.setState({ActivePage: page});

    render() {
        return (
            <div className="container-fluid">
                <SWContext.Provider value={
                    {
                        page: this.state.ActivePage,
                        changePage: this.changePage
                    }
                }>
                    <Header/>
                    <Main/>
                </SWContext.Provider>
                <Footer/>
            </div>
        );
    }
}

export default App;
