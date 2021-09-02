
import React from "react";
import { useRef } from "react";
import classes from './Form.module.css';

function ReportBug(props){
    const titleInputRef = useRef();
	const dateInputRef = useRef();
	const priceInputRef = useRef();

	function submitHandler(event) {
		event.preventDefault();

		const enteredTitle = titleInputRef.current.value;
		const enteredDate = dateInputRef.current.value;
		const enteredPrice = priceInputRef.current.value;

		const bugData = {
			title: enteredTitle,
			date: enteredDate,
			price: enteredPrice,
		};
		
		props.onAddTrip(bugData);
	}
		
    return(
        <div>
        <h1 className={classes.title}>Report Bug</h1>
        <div style={{
            display: 'block', width: 400, padding: 2
        }}>

			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor="title"></label>
					<input type="text" required id="title" ref={titleInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="date">When</label>
					<input type="date" required id="date" ref={dateInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="price">Price</label>
					<input type="number" required ref={priceInputRef} />
				</div>
				<div className={classes.actions}>
					<button> Add Trip</button>
				</div>
			</form>
		
        </div>
    </div>
	);
}


export default ReportBug;