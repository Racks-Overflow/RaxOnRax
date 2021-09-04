import React from "react";


import '@blueprintjs/core/lib/css/blueprint.css';
import { Tabs, Tab } from "@blueprintjs/core";
import NewTripForm from "../components/Forms/NewTripForm";

  
function Trip() {
    return (
        <div style={{
            display: 'block', width: 400, padding: 2
        }}>
            <Tabs
                animate={true}
                key={"vertical"}
                vertical={false}
            >
                <Tab id="trip-list" title="List of Trips" panel={
                    <p>
                        <div>List Of Trips Coming soon.</div>
                    </p>
                } />
                <Tab id="trip-admin-list" title="List of Admin Trips" panel={
                    <p>
                        <h2>List Of Admin Trips Coming Soon</h2>
                    </p>
                } />
                <Tab id="trip-members" title="Trip Members" panel={
                    <p>List of Members on a trip Coming soon.</p>
                } />
                <Tab id="new-trip" title="Make a Trip" panel={
                    <NewTripForm />
                } />
            </Tabs>
        </div >
    );
}
  
export default Trip;

