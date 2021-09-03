import Tabs from "../components/account/Settings";
import React from "react";
import Card from "../components/ui/Card";
import classes from './Account.module.css'


function Account(){
    return (
        
        <div className={classes.title}>
          <h1>Your Account</h1>
          <Tabs />
      
        </div>
        
      );
}

export default Account;