
import React from "react";
import { useRef } from "react";
import classes from './Form.module.css';

function ReportBug(props){
    const titleInputRef = useRef();
	const issueInputRef = useRef();
	const descriptionInputRef = useRef();

	function submitHandler(event) {
		event.preventDefault();

		const enteredTitle = titleInputRef.current.value;
		const enteredIssue = issueInputRef.current.value;
		const enteredDescription = descriptionInputRef.current.value;

		const bugData = {
			title: enteredTitle,
			issue: enteredIssue,
			description: enteredDescription
		};
		
		props.sendReport(bugData);
	}
		
    return(
        <div>
        <h1 className={classes.title}>Report Bug</h1>
        <div style={{
            display: 'block', width: 400, padding: 2
        }}>

			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor="title">Name</label>
					<input type="text" required id="title" ref={titleInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="date">Issue</label>
					<input type="text" required id="date" ref={issueInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="description">Description</label>
					<input type="text" required ref={descriptionInputRef} />
				</div>
				<div className={classes.actions}>
					<button> Report Bug</button>
				</div>
			</form>
		
        </div>
    </div>
	);
}


export default ReportBug;