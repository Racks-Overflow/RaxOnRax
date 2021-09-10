import React from "react";
import { useRef } from "react";
import NewSignInForm from "./SignUpF";
import { useHistory } from "react-router";

function SignUp(props){
	const history = useHistory();
    
    function SignUpHandler(userData) {
        fetch(
			'https://stax-67bce-default-rtdb.firebaseio.com/newsignin.json',
			{
				method: 'POST',
				body: JSON.stringify(userData),
				headers: {
					"Content-Type": "application/json",
				}
			}
		).then(() => {
            history.replace('/');
          });
    
	}
    return(
        <section>
            <h1>Sign-Up</h1>
    <SignUpForm onSignUp={SignUpHandler} />
       </section> 
       );
    }

export default NewSignIn;