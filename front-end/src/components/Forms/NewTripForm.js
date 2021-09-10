/** @format */
import React from "react";
import { useRef } from "react";
import Card from "../ui/Card";
import classes from "./NewTripForm.module.css";


function NewTripForm(props) {
	
	const destinationInputeRef = useRef();
	const tripEstimationInputRef = useRef();
	const dateInputRef = useRef();
	const groupSizeInputRef=useRef();

	function submitHandler(event) {
		event.preventDefault();

		const enteredDestination = destinationInputeRef.current.value;
		const enteredTripEstimate = tripEstimationInputRef.current.value;
		const enteredDate = dateInputRef.current.value;
		const enteredGroupSize= groupSizeInputRef.current.value;

		const tripData = {
			destination: enteredDestination,
			tripEstimate: enteredTripEstimate,
			date: enteredDate,
			groupSize: enteredGroupSize,

		};
		
		props.onNewTrip(tripData)

	}
		
	return (
		<Card>
			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor="title">Trip Destination</label>
					<input type="text" required id="destination" ref={destinationInputeRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="date">Date</label>
					<input type="date" required id="date" ref={dateInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="price">Group Estimate</label>
					<input type="number" minLength="50" maxLength="1000000"required ref={tripEstimationInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="group">Group Size</label>
					<input type="number" minLength="1" maxLength="200" required ref={groupSizeInputRef} />
				</div>
				<div className={classes.actions}>
					<button > Add Trip</button>
				</div>
			</form>
		</Card>
	);
}
export default NewTripForm;
