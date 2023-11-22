import {signInWithEmailAndPassword, signOut, createUserWithEmailAndPassword} from "firebase/auth";
import {auth} from '../firebase-config';

export function login(email, pass) {
   return signInWithEmailAndPassword(auth, email, pass);
}

export function logout() {
    signOut(auth)
        .then(response => alert('Logout success'))
        .catch(error => alert(error));
}

export function registartion(email, pass) {
    createUserWithEmailAndPassword(auth, email, pass)
        .then(response => alert('Registration success'))
        .catch(error => alert(error));
}

export async function getUid() {
    const user = auth.currentUser;
    if (user !== null) {
        return user.uid
    }
}