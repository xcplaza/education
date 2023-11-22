import {doc, getDoc, updateDoc, arrayUnion, setDoc} from 'firebase/firestore';
import {db} from "../firebase-config";

export async function addToDo(uid, title) {
    const ref = doc(db, 'todos', uid);
    const temp = await getDoc(ref);

    if (temp.exists()) {
        await updateDoc(ref, {todo: arrayUnion(title)})
    } else {
        await setDoc(ref, {todo: [title]});
    }
}

export async function getAllTasks(uid) {
    const ref = doc(db, 'todos', uid);
    const temp = await getDoc(ref);
    return temp.exists() ? temp.data() : {todo: []};
}

export async function updateTask(uid, tasks) {
    const ref = doc(db, 'todos', uid);
    await updateDoc(ref, {todo: tasks});

}