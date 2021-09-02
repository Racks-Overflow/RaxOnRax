/** @format */

import classes from "./TripList.module.css";
import TripItem from "./TripItem";

function TripList(props) {
	return (
		<ul className={classes.list}>
			{props.trips.map((trip) => (
				<TripItem
					key={trip.id}
					id={trip.id}
					image={trip.image}
					title={trip.title}
					address={trip.address}
					description={trip.description}
				/>
			))}
		</ul>
	);
}

export default TripList;
