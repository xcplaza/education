import React, {useRef, useState} from 'react';

interface Props {
    deleteTask: (index: number) => void;
    updateTask: (index: number, value: string) => void;
    index: number;
    children: string;
}

// const Task: React.FunctionComponent<Props> = ({deleteTask, updateTask, index, children}) =>
// OR
// const Task: React.FC<Props> = ({deleteTask, updateTask, index, children}) =>
// OR
const Task = ({deleteTask, updateTask, index, children}: Props) => {
    const newText = useRef<HTMLTextAreaElement>(null);
    const [isEdit, setIsEdit] = useState<boolean>(true);

    const handleClickEdit = () => setIsEdit(true);
    const handleClickRemove = () => deleteTask(index);

    const handleClickSave = () => {
        const value = newText.current!.value;
        // const value = (this.newText.current as HTMLTextAreaElement).value;
        // @ts-ignore
        // const value = this.newText.current.value;
        updateTask(index, value);
        setIsEdit(false);
    }
    const renderNorm = () => {
        return (
            <div className={'box'}>
                {/*<div>{this.props.task}</div>*/}
                <div>{children}</div>
                <button className={'btn light'} onClick={handleClickEdit}>Edit</button>
                <button className={'btn red'} onClick={handleClickRemove}>Remove</button>
            </div>
        );
    }
    const renderEdit = () => {
        return (
            <div className={'box'}>
                <textarea ref={newText} defaultValue={children}></textarea>
                <button className={'btn success'} onClick={handleClickSave}>Save</button>
            </div>
        )
    }
    return isEdit ? renderEdit() : renderNorm();
}

export default Task;