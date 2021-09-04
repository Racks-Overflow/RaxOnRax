import { useEffect, useState } from "react";
import TripList from "../components/trip/TripList";

function Trips() {
	const [isLoading, setIsLoading] = useState(true);
	const [loadedTrips, setLoadedTrips] = useState([]);

	useEffect(() => {
    setIsLoading(true);
		fetch(
      'jdbc:mysql://localhost:3306/rackdata/see-all')
			.then((response) => {
				return response.json();
			})
			.then((data) => {
        const trips = [];

        for(const key in data){
          const trip={
            id: key,
            ...data[key]
          };
          trips.push(trip);
        }



				setIsLoading(false);
				setLoadedTrips(data);
			});
	}, []);

	if (isLoading) {
		return (
			<section>
				<p> Loading...</p>
			</section>
		);
	}

	return (
		<section>
			<h1>All Trips</h1>
			<TripList trips={loadedTrips} />
		</section>
	);
}

export default Trips;