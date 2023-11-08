import React, {Component} from 'react';
import MyClassComponent from "./MyClassComponent";
import Timer from "./Timer";
import StarWars from "./StarWars";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {isShow: true};
    }

    render() {
        return (
            <div>
                <button onClick={() => this.setState({isShow: false})}>Die</button>
                {this.state.isShow ? <MyClassComponent/> : null}
                {this.state.isShow ? <Timer/> : null}
                <StarWars/>
            </div>
        );
    }
}

export default App;


// import './App.css';
// import MyComponent from "./MyComponent";
// import MyClassComponent from "./MyClassComponent";
//
// function App() {
//     return (
//         <div className="App">
//             {/*<MyComponent/>*/}
//             <MyClassComponent/>
//         </div>
//     );
// }
//
// export default App;
