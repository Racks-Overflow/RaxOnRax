import axios from "axios";

const TRIP_API ="http://localhost3300/tripcontroller";

const createTrip = (destination, date, groupSize, totalEstimate) => {
    return axios.post(TRIP_API + "create", {
        destination,
        date,
        groupSize,
        totalEstimate,
    });
};

const 