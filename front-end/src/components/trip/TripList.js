import classes from "./TripList.module.css";
import TripItem from "./TripItem";

function TripList(props) {
	return (
		<ul className={classes.list}>
			{props.trips.map((trip) => (
				<TripItem
					key={trip.id}
					id={trip.id}
					destination={trip.destination}
					gropuSize={trip.groupSize}
					tripEstimate={trip.tripEstimate}
					balance={trip.balance}
					totalSpent={trip.totalSpent}
					estimatePerPerson={trip.estimatePerPerson}
					isActive={trip.isActive}
					
				/>
			))}
		</ul>
	);
}

export default TripList;








// import React, { useState, useEffect } from "react";
// import TripServices from "../../services/TripServices";
// import { Link } from "react-router-dom";

// const TripList = () => {
//   const [trips, setTrips] = useState([]);
//   const [currentTrip, setCurrentTrip] = useState(null);
//   const [currentIndex, setCurrentIndex] = useState(-1);
//   const [searchDestination, setSearchDestination] = useState("");

//   useEffect(() => {
//     retrieveTrips();
//   }, []);

//   const onChangeSearchDestination = e => {
//     const searchDestination = e.target.value;
//     setSearchDestination(searchDestination);
//   };

//   const retrieveTrips = () => {
//     TripServices.getAllTrips
//       .then(response => {
//         setTrips(response.data);
//         console.log(response.data);
//       })
//       .catch(e => {
//         console.log(e);
//       });
//   };

//   const refreshList = () => {
//     retrieveTrips();
//     setCurrentTrip(null);
//     setCurrentIndex(-1);
//   };

//   const setActiveTrips = (trip, index) => {
//     setCurrentTrip(trip);
//     setCurrentIndex(index);
//   };

//   const endTrip = () => {
//     TripServices.endTrip()
//       .then(response => {
//         console.log(response.data);
//         refreshList();
//       })
//       .catch(e => {
//         console.log(e);
//       });
//   };

//   const findByDestination = () => {
//     TripServices.getTripByDestination(searchDestination)
//       .then(response => {
//         setTrips(response.data);
//         console.log(response.data);
//       })
//       .catch(e => {
//         console.log(e);
//       });
//   };

//   return (
//     <div className="list row">
//       <div className="col-md-8">
//         <div className="input-group mb-3">
//           <input
//             type="text"
//             className="form-control"
//             placeholder="Search by title"
//             value={searchDestination}
//             onChange={onChangeSearchDestination}
//           />
//           <div className="input-group-append">
//             <button
//               className="btn btn-outline-secondary"
//               type="button"
//               onClick={findByDestination}
//             >
//               Search
//             </button>
//           </div>
//         </div>
//       </div>
//       <div className="col-md-6">
//         <h4>Trip List</h4>

//         <ul className="list-group">
//           {trips &&
//             trips.map((trip, index) => (
//               <li
//                 className={
//                   "list-group-item " + (index === currentIndex ? "active" : "")
//                 }
//                 onClick={() => setActiveTrips(trip, index)}
//                 key={index}
//               >
//                 {trip.destination}
//               </li>
//             ))}
//         </ul>

//         <button
//           className="m-3 btn btn-sm btn-danger"
//           onClick={endTrip}
//         >
//           EndTrip
//         </button>
//       </div>
//       <div className="col-md-6">
//         {currentTrip ? (
//           <div>
//             <h4>Trip</h4>
//             <div>
//               <label>
//                 <strong>Destination:</strong>
//               </label>{" "}
//               {currentTrip.destination}
//             </div>
//             <div>
//               <label>
//                 <strong>Date:</strong>
//               </label>{" "}
//               {currentTrip.date}
//             </div>
//             <div>
//               <label>
//                 <strong>Status:</strong>
//               </label>{" "}
//               {currentTrip.published ? "Active" : "Inactive"}
//             </div>

//             <Link
//               to={"/trips/" + currentTrip.id}
//               className="badge badge-warning"
//             >
//               Edit
//             </Link>
//           </div>
//         ) : (
//           <div>
//             <br />
//             <p>Please click on a Trip...</p>
//           </div>
//         )}
//       </div>
//     </div>
//   );
// };
