/** @format */
import React from "react";
import { useRef } from "react";
import Card from "../ui/Card";
import classes from "./NewTripForm.module.css";

function NewTripForm(props) {
	const titleInputRef = useRef();
	const dateInputRef = useRef();
	const priceInputRef = useRef();

	function submitHandler(event) {
		event.preventDefault();

		const enteredTitle = titleInputRef.current.value;
		const enteredDate = dateInputRef.current.value;
		const enteredPrice = priceInputRef.current.value;

		const tripData = {
			title: enteredTitle,
			date: enteredDate,
			price: enteredPrice,
		};
		
		props.onAddTrip(tripData);
	}
		

	return (
		<Card>
			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor="title">Trip Name</label>
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
		</Card>
	);
}
export default NewTripForm;
