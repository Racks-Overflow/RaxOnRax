import React from "react";


import '@blueprintjs/core/lib/css/blueprint.css';
import { Tabs, Tab } from "@blueprintjs/core";
import NewTripForm from "../Forms/NewTripForm";
import ChangePassword from "./ChangePassword";
import UserName from "./Username";

  
function Settings() {
    return (
        <div style={{
            display: 'block', width: 400, padding: 2
        }}>
            <Tabs
                animate={true}
                key={"vertical"}
                vertical={false}
            >
                <Tab id="username" title="UserName" panel={
                    <p>
                        <UserName />
                    </p>
                } />
                <Tab id="password" title="Password" panel={
                    <p>
                        <ChangePassword />
                    </p>
                } />
                <Tab id="creditCard" title="Credit Card" panel={
                    <p>Sample Content 1</p>
                } />
                <Tab id="balance" title="Check Balance" panel={
                    <div><h2>hello</h2></div>
                } />
            </Tabs>
        </div >
    );
}
  
export default Settings;
