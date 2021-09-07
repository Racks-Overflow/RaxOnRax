import axios from "axios";

const TRIP_API ="http://localhost3300/tripcontroller/";

const createTrip = (destination, date, groupSize, totalEstimate) => {
    return axios.post(TRIP_API + "create", {
        destination,
        date,
        groupSize,
        totalEstimate,
    });
};

const getAllTrips = () => {
    return axios.get(TRIP_API + "see-all");
};

const getTripById = (id) => {
    return axios.get(TRIP_API+"find-trip/{id}");
}

const getTripByDestination = (destination) => {
    return axios.get(TRIP_API+"find-destination/{destination}");
}

const addGuest =(tripId, accountId) => {
    return axios.post(TRIP_API+"{trip_id}/invite/{accountId}");
}
const assignAdmin = (tripId, accountId) => {
    return axios.post(TRIP_API, "{trip_id}/assign-admin/{accountId}");
}

const removeGuest = (tripId, accountId) => {
    return axios.delete(TRIP_API+"{tripId}/remove/{accountId}");
}

const poolFunds = (tripId) => {
    return axios.update(TRIP_API+"{id}/pool-funds");
}

const payBill= (id, balance) => {
    return axios.update(TRIP_API+"{id}/pay/{cost}");
}

const endTrip = (tripId) => {
    return axios.update(TRIP_API+"{id}/return-trip-funds");
}
