import React, { Component } from "react";


class BasicButton extends Component{

    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.props;
    }

    render() {
      return (
        <button onClick={this.handleClick}>
        why tho
        </button>
    );
    }
    
}
export default Button;