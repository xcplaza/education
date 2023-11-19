import './App.css';
import Operation from "./components/Operation";
import Balance from "./components/Balance";

function App() {
    // const [balance, setBalance] = useState(10);
    // const deposit = sum => setBalance(prevBalance => prevBalance + sum);
    // const withdraw = sum => setBalance(prevState => (prevState - sum) < 0 ? prevState : prevState - sum);

    return (
        <div className="App">
            <Balance/>
            <Operation/>
        </div>
    );
}

export default App;
