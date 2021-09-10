import React from "react";
import Card from "../ui/Card";
import classes from './NewSignIn.module.css';
import { useState } from "react";
import SignIn from "../../pages/Login";



export default function SignInForm({Login, error}) {
	const [details, setDetails] = useState({name:"", email:"", password:""});

	const submitHandler = e => {
		e.preventDefault();

		SignIn(details);
	}

	return (
		<form onSubmit={submitHandler}>
		<div className="form-inner">
			<h2>Login</h2>
			{(error != "") ? (<div className="error">{error}</div>) : ""}
			<div className="form-group">
				<label htmlFor="name">Name:</label>
				<input type= "text" name="namee" id="name" onChange={e=> setDetails({...details, name: e.target.value})} value={details.name}  />
			</div>
			<div classNae="form-group">
				<label htmlFor="email">Email: </label>
				<input type="email" name="email" id="email" onChange={e=> setDetails({...details, email: e.target.value})} value={details.email}/>
			</div>
			<div className="form-group">
				<label htmlFor="password">Password:</label>
				<input type="password" name="password" id="password" onChange={e=> setDetails({...details, password: e.target.value})} value={details.password}/>
			</div>
			<input type="submit" value="LOGIN" />
		</div>
		</form>
	)
}


// function SignInForm(props){
//     const emailInputRef = useRef();
// 	const passwordInputRef = useRef();

// 	function submitHandler(event){
// 		event.preventDefault();

// 		const enteredEmail=emailInputRef.current.value;
// 		const enteredPassword=passwordInputRef.current.value;
		

// 		const userData = {
// 			email: enteredEmail,
// 			password: enteredPassword,
// 		};
// 		props.onSignIn(userData);
// 	}
//     return (
// 		<Card>
// 			<form className={classes.form} onSubmit={submitHandler}>
// 				<div className={classes.control}>
// 					<label htmlFor='title'>Email</label>
// 					<input type='text' required id='email' ref={emailInputRef} />
// 				</div>
// 				<div className={classes.control}>
// 					<label htmlFor="title">Password</label>
// 					<input type="text" required id="password" ref={passwordInputRef} />
// 				</div>
//                 <div className={classes.actions}>
//                     <button>Sign-In</button>
//                     <button className='btn' onClick={SignUpForm}>
//                             Create Login
//                         </button> 
//                 </div>

// 			</form>
// 		</Card>
// 	);
// } 

// export default SignInForm;