import Tabs from "../components/account/Settings";
import React from "react";
import Card from "../components/ui/Card";
import classes from './Page.module.css'


function Account(){
    return (
        <Card>
        <div>
          <h1>Your Account</h1>
          <Tabs>
        <div label="Gator">
          See ya later, <em>Alligator</em>!
        </div>
        <div label="Croc">
          After 'while, <em>Crocodile</em>!
        </div>
        <div label="Sarcosuchus">
          Nothing to see here, this tab is <em>extinct</em>!
        </div>
      </Tabs>
        </div>
        </Card>
      );
}

export default Account;