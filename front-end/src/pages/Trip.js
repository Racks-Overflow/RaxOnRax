import React from "react";
import '@blueprintjs/core/lib/css/blueprint.css';
import { Tabs, Tab } from "@blueprintjs/core";
import NewTripForm from "../components/Forms/NewTripForm";
import Invite from "../components/trip/Invite";
import Trips from "../components/trip/AllTrips";
import TripUsers from "../components/trip/TripUsers";
import AddTrip from "../components/trip/CreateTrip";
import TripList from "../components/trip/TripList";
import NewTripPage from "../components/Forms/NewTrip";



  
function Trip() {
    return (
        <div style={{
            display: 'block', width: 1000, padding: 15
        }}>
            <Tabs
                animate={true}
                key={"vertical"}
                vertical={false}
            >
                <Tab id="trip-list" title="List of Trips" panel={
                    <p>
                        <div><Trips /></div>
                    </p>
                } />
                <Tab id="trip-admin-list" title="Manage Trips" panel={
                    <p>
                       
                    </p>
                } />
                <Tab id="trip-members" title="Trip" panel={
                    <TripUsers />
                } />
                <Tab id="new-trip" title="Make a Trip" panel={
                    <NewTripPage />
                } />
            </Tabs>
        </div >
    );
}
  
export default Trip;

