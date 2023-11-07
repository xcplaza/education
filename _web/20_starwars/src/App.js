import './App.css';
import Header from "./components/Header";
import Main from "./components/Main";
import Footer from "./components/footer/Footer";

function App() {
    return (
        <div className="container-fluid">
            <Header/>
            <Main/>
            <Footer/>
        </div>
    );
}

export default App;
