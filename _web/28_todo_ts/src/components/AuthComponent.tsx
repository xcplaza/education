import React, {useState} from 'react';
import {getUid, login, logout, registartion} from "../config/authConfig";

interface Props {
    disabledTodo: (disabled: boolean) => void
}

const AuthComponent = ({disabledTodo}: Props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('')
    const [uid, setUid] = useState<string>()

    const handleClickLogin = () => {
        login(email, pass)
            .then(() => {
                getUid()
                    .then(data => {
                        setUid(data);
                        disabledTodo(data == undefined);
                        // alert('Login success');
                    })
                    .catch(() => alert('Wrong user!'))
            })
    }

    const handleClickLogout = () => {
       logout();
       disabledTodo(true);
    }
    return (
        <div>
            <div>
                <input type={'text'} placeholder={'Type email'} value={email}
                       onChange={e => setEmail(e.target.value)}/>
                <input type={'password'} placeholder={'Type password'} value={pass}
                       onChange={e => setPass(e.target.value)}/>
            </div>
            <div>
                <button onClick={handleClickLogin}>Login</button>
                <button onClick={handleClickLogout}>Logout</button>
                <button onClick={() => registartion(email, pass)}>Register</button>
            </div>
        </div>
    );
};

export default AuthComponent;