import React from "react";
import Card from "../ui/Card";
import classes from "./NewSignIn.module.css";
import { useRef } from "react";

function SignInForm(props){
    const emailInputRef = useRef();
	const passwordInputRef = useRef();

	function submitHandler(event){
		event.preventDefault();

		const enteredEmail=emailInputRef.current.value;
		const enteredPassword=passwordInputRef.current.value;
		

		const userData = {
			email: enteredEmail,
			password: enteredPassword,
		};
		props.onSignIn(userData);
	}
    return (
		<Card>
			<form className={classes.form} onSubmit={submitHandler}>
				<div className={classes.control}>
					<label htmlFor='title'>Email</label>
					<input type='text' required id='email' ref={emailInputRef} />
				</div>
				<div className={classes.control}>
					<label htmlFor="title">Password</label>
					<input type="text" required id="password" ref={passwordInputRef} />
				</div>
                <div className={classes.actions}>
                    <button>Sign-In</button>
                    {/* <button className='btn' onClick={NewSignInForm}>
                            Create Login
                        </button> */}
                </div>

			</form>
		</Card>
	);
} 

export default SignInForm;