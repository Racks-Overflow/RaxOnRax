import { useEffect, useState } from "react";
import TripServices from "../../services/TripServices";
import TripList from "./TripList";

function Trips(props) {

	const [isLoading, setIsLoading] = useState(true);
	const [loadedTrips, setLoadedTrips] = useState([]);

	useEffect(() => {
    setIsLoading(true);
		fetch(
      'https://stax-overflow.herokuapp.com/tripcontroller/see-all')
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
			<TripList trips={loadedTrips}/>
		</section>
	);
}
export default Trips;