

import classes from "./TripList.module.css";
import TripItem from "./TripItem";

function TripList(props) {
	return (
		<ul className={classes.list}>
			{props.trips.map(trip => (
				<TripItem
					key={trip.id}
					id={trip.id}
					destination={trip.destination}
					groupSize={trip.groupSize}
					tripEstimate={trip.tripEstimate}
					balance={trip.tripBalance}
					totalSpent={trip.totalSpent}
					estimatePerPerson={trip.estimatePerPerson}
					isActive={trip.isActive}
				/>
			))}
		</ul>
	);
}

export default TripList;