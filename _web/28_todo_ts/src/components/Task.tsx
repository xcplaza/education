import React, {Component} from 'react';

interface Props {
    deleteTask: (index: number) => void;
    updateTask: (index: number, value: string) => void;
    index: number;
    children: string;
}

interface State {
    isEdit: boolean;
}

class Task extends Component<Props, State> {
    private newText = React.createRef<HTMLTextAreaElement>();

    constructor(props: Props) {
        super(props);
        this.state = {isEdit: true};
    }

    handleClickEdit = () => this.setState({isEdit: true});

    handleClickRemove = () => this.props.deleteTask(this.props.index);

    handleClickSave = () => {
        const value = this.newText.current!.value;
        // const value = (this.newText.current as HTMLTextAreaElement).value;
        // @ts-ignore
        // const value = this.newText.current.value;
        this.props.updateTask(this.props.index, value);
        this.setState({isEdit: false});
    }

    renderNorm = () => {
        return (
            <div className={'box'}>
                {/*<div>{this.props.task}</div>*/}
                <div>{this.props.children}</div>
                <button className={'btn light'} onClick={this.handleClickEdit}>Edit</button>
                <button className={'btn red'} onClick={this.handleClickRemove}>Remove</button>
            </div>
        );
    }

    renderEdit = () => {
        return (
            <div className={'box'}>
                <textarea ref={this.newText} defaultValue={this.props.children}></textarea>
                <button className={'btn success'} onClick={this.handleClickSave}>Save</button>
            </div>
        )
    }

    render() {
        return this.state.isEdit ? this.renderEdit() : this.renderNorm();
    }
}

export default Task;