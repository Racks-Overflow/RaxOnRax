import { useEffect, useState } from "react";
import TripList from "./TripList";

const dummydata =[
    {
        id: '1',
        adminUsername: 'user2',
		destination: 'Istanbol',
		tripEstimate: '25,000',
		balance: '0',
		isActive: 'true'
    },
    {
        id: '2',
        adminUsername: 'user2',
		destination: 'Maraco',
		tripEstimate: '25,000',
		balance: '0',
		isActive: 'true'
    },
    {
        id: '3',
        adminUsername: 'user3',
		destination: 'Singapore',
		tripEstimate: '25,000',
		balance: '0',
		isActive: 'true'
    },
]


function Trips() {
	// const [isLoading, setIsLoading] = useState(true);
	// const [loadedTrips, setLoadedTrips] = useState([]);

	// useEffect(() => {
    // setIsLoading(true);
	// 	fetch(
    //   'jdbc:mysql://localhost:3306/rackdata/see-all')
	// 		.then((response) => {
	// 			return response.json();
	// 		})
	// 		.then((data) => {
    //     const trips = [];

    //     for(const key in data){
    //       const trip={
    //         id: key,
    //         ...data[key]
    //       };
    //       trips.push(trip);
    //     }



	// 			setIsLoading(false);
	// 			setLoadedTrips(data);
	// 		});
	// }, []);

	// if (isLoading) {
	// 	return (
	// 		<section>
	// 			<p> Loading...</p>
	// 		</section>
	// 	);
	// }

	return (
		<section>
			<h1>All Trips</h1>
			<TripList trips={dummydata} />
		</section>
	);
}
export default Trips;