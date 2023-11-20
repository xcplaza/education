class Car {
    private regNumber: string
    protected model: string = 'unknown'
    readonly color: string

    constructor(regNumber: string, model: string, color: string) {
        this.regNumber = regNumber;
        this.model = model;
        this.color = color;
    }

    getRegNumber = (): string => this.regNumber;
    setRegNumber = (regNumber: string) => this.regNumber = regNumber
}

abstract class Component {
    abstract render(): void;
}

class App extends Component {
    render() {
        console.log('Render component app');
    }
}