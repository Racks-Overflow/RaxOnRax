import http from "./http-common";


const createTrip = (
    date,
    destination,
    groupSize,
    tripEstimate,
    ) => {
    return http.post(`tripcontroller/create`,
    {
        "date":date,
        "destination":destination,
        "groupSize": groupSize,
        "tripEstimate":tripEstimate,
        "groupBalance": 0,
        "totalSpent": 0,
        "estimatePerPerson":0,
        "isActive":false,
        "admin":null,
    });
};

const getAllTrips = () => {
    return http.get("tripcontroller/see-all");
};

const getTripById = id => {
    return http.get(`tripcontroller/find-trip/${id}`,{
        id,
    });
}

const getTripByDestination = destination => {
    return http.get(`tripcontroller/find-destination/${destination}`,{
        destination,
    });
}

const addGuest =(tripId, accountId) => {
    return http.post(`tripcontroller/${tripId}/invite/${accountId}`,{
        tripId,
        accountId,
    });
}
const assignAdmin = (tripId, accountId) => {
    return http.post(`tripcontroller/${tripId}/assign-admin/${accountId}`,{
        tripId,
        accountId,
    });
}

const removeGuest = (tripId, accountId) => {
    return http.delete(`tripcontroller/${tripId}/remove/${accountId}`,{
        tripId,
        accountId,
    });
}

const poolFunds = tripId => {
    return http.put(`tripcontroller/${tripId}/pool-funds`,{
        tripId,
    });
}

const payBill= (id, balance) => {
    return http.put(`tripcontroller/${id}/pay/${balance}`,{
        id,
        balance,
    });
}

const endTrip = (tripId) => {
    return http.put(`tripcontroller/${tripId}/return-trip-funds`,{
        tripId,
    });
}



export default {
    createTrip,
    getAllTrips,
    getTripByDestination,
    getTripById,
    poolFunds,
    payBill,
    endTrip,
    assignAdmin,
    addGuest,
    removeGuest,
};
