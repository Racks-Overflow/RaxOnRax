import React from "react";
import { useRef } from "react";
import NewSignInForm from "./NewSignInForm";

function NewSignIn(props){
    
    function newSignInHandler(userData) {
        fetch(
			'https://stax-67bce-default-rtdb.firebaseio.com/newsignin.json',
			{
				method: 'POST',
				body: JSON.stringify(userData),
				headers: {
					"Content-Type": "application/json",
				}
			}
		);
	}
    return(
        <section>
            <h1>Please Sign-In</h1>
    <NewSignIn onNewSignIn={newSignInHandler} />
       </section> 
       );
    }

export default NewSignIn;