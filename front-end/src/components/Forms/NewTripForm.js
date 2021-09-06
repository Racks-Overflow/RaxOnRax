/** @format */
import React from "react";
import { useRef } from "react";
import Card from "../ui/Card";
import classes from "./NewTripForm.module.css";

function NewTripForm(props) {
	const destinationInputeRef = useRef();
	const tripEstimationInputRef = useRef();
	const dateInputRef = useRef();

	function submitHandler(event) {
		event.preventDefault();

		const enteredDestination = destinationInputeRef.current.value;
		const enteredTripEstimate = tripEstimationInputRef.current.value;
		const enteredDate = dateInputRef.current.value;

		const tripdata = {
			destination: enteredDestination,
			tripEstimate: enteredTripEstimate,
			date: enteredDate,
		};
		
	props.onAddTrip(tripdata);

	}
		

	return (
		<Card>
			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor="title">Trip Destinatoin</label>
					<input type="text" required id="destination" ref={destinationInputeRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="date">When</label>
					<input type="date" required id="date" ref={dateInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="price">Group Price</label>
					<input type="number" required ref={tripEstimationInputRef} />
				</div>
				<div className={classes.actions}>
					<button> Add Trip</button>
				</div>
			</form>
		</Card>
	);
}
export default NewTripForm;
