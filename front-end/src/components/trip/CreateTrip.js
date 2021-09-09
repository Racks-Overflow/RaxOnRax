

import React, { useState } from "react";
import TripServices from "../../services/TripServices";

const AddTrip = () => {
	const initialTripState = {
		date: "",
		destination: "",
		groupSize: "",
		tripEstimate: "",
	};
	const [trip, setTrip] = useState(initialTripState);
	const [submitted, setSubmitted] = useState(false);

	const handleInputChange = (event) => {
		const { name, value } = event.target;
		setTrip({ ...trip, [name]: value });
	};

	const saveTrip = () => {
		var data = {
			"date": trip.date,
			"destination": trip.destination,
			"groupSize": trip.groupSize,
			"tripEstimate": trip.tripEstimate,
		};

		TripServices.createTrip(data)
			// date,
			// destination,
			// groupSize,
			// tripEstimate,
			// groupBalance,
			// totalSpent,
			// estimatePerPerson,
			// isActive,
			// admin)
			.then((response) => {
				setTrip({
					date: response.data.date,
					destination: response.data.destination,
					groupSize: response.data.groupSize,
					tripEstimate: response.data.tripEstimate,
				});
				setSubmitted(true);
				console.log(response.data);
			})
			.catch((e) => {
				console.log(e);
			});
	};

	const newTrip = () => {
		setTrip(initialTripState);
		setSubmitted(true);
	};

	return (
		<div className="submit-form">
			{submitted ? (
				<div>
					<h4>You Created A Trip successfully!</h4>
					<button className="btn btn-success" onClick={newTrip}>
						Add
					</button>
				</div>
			) : (
				<div>
					<div className="form-group">
						<label htmlFor="title">Destination</label>
						<input
							type="text"
							className="form-control"
							id="title"
							requiredValue={trip.destination}
							onChange={handleInputChange}
							name="destination"
						/>
					</div>
					<div className="form-group">
						<label htmlFor="date">Date</label>
						<input
							type="date"
							className="form-control"
							id="date"
							required
                            value={trip.date}
							onChange={handleInputChange}
							name="date"
						/>
					</div>

					<div className="form-group">
						<label htmlFor="description">Trip Size</label>
						<input
							type="text"
							className="form-control"
							id="groupSize"
							required
							value={trip.groupSize}
							onChange={handleInputChange}
							name="groupSize"
							minLength="1"
							maxLength="200"
						/>
					</div>
					<div className="form-group">
						<label htmlFor="tripEstimate">Trip Estimate</label>
						<input
							type="number"
							className="form-control"
							id="tripEstimate"
							required
							value={trip.tripEstimate}
							onChange={handleInputChange}
							name="tripEstimate"
							minLength="50"
							maxLength="1000000"
						/>
					</div>

					<button onClick={saveTrip} className="btn btn-success">
						Submit
					</button>
				</div>
			)}
		</div>
	);
};

export default AddTrip;
