function Block() {
    const subTitle = 'Hello world!'
    return (
        <React.Fragment>
            {/*<h1>Class component</h1>*/}
            <h3>Hello Karmiel</h3>
            <p>{3 + 5 - 1 / 40}</p>
            <p>{Math.random() * 100}</p>
            <h2>{subTitle}</h2>
        </React.Fragment>);
}
ReactDOM.render(<Block/>, document.querySelector('#root'));