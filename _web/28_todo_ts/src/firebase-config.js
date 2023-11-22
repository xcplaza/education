import {getAuth} from "firebase/auth";
import {initializeApp} from "firebase/app";
import { getFirestore } from "firebase/firestore";


const firebaseConfig = {
    apiKey: "AIzaSyASDvP7ln570dR9ErAAmjH1u2lVT1liTME",
    authDomain: "karmiel-1.firebaseapp.com",
    projectId: "karmiel-1",
    storageBucket: "karmiel-1.appspot.com",
    messagingSenderId: "518556667469",
    appId: "1:518556667469:web:13de40fe28fa03974f5604"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
export const db = getFirestore(app);