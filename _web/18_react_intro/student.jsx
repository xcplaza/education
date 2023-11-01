// class Student extends React.Component {
//     render() {
//         return (
//             <div>
//                 <h2>{this.props.name}</h2>
//                 <h3>{this.props.age}</h3>
//             </div>
//         )
//     }
// }

function Student(props) {
    return (
        <div>
            <h2>{props.name}</h2>
            <h3>{props.age}</h3>
        </div>
    )
}

ReactDOM.render(
    <div>
        <Student name={'Masha'} age={21}/>
        <Student name={'Pasha'} age={29}/>
        <Student name={'Sasha'} age={19}/>
    </div>, document.querySelector('#root'));