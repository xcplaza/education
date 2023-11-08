import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";
import {Component} from "react";
import {navItemsArray} from "./utils/constans";


class App extends Component {

    constructor(props) {
        super(props);
        this.state = {ActivePage: navItemsArray[3]};
    }

    changePage = page => this.setState({ActivePage: page});

    render() {
        return (
            <div className="container-fluid">
                <Header changePage={this.changePage}/>
                <Main page={this.state.ActivePage}/>
                <Footer/>
            </div>
        );
    }
}

export default App;
