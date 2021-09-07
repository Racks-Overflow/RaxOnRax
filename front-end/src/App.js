/** @format */
import { useState } from "react";
import Header from "./components/layout/Header";
import SignInForm from "./components/Forms/LoginForm";


export default function App() {
	


	// const adminUser = {
	// 	email: 'adminUser@gmon.com',
	// 	password: 'zipcode0'
	// }

	// const [user, setUser] = useState({name:"", email: ""});
	// const [error, setError]= useState("");

	// const SignIn = details => {
	// 	console.log(details);

	// 	if (details.email==adminUser.email && details.password ==adminUser.password){
	// 		console.log("Logged In");
	// 		setUser({
	// 			name: details.name,
	// 			email: details.email
	// 		});
	// 	} else {
	// 		console.log("Details do not Match!");
	// 		setError("Details do not Match!")
	// 	}

	// }

	// const Logout =()=>{
	// 	setUser({ name:"", email: "", password: ""})
	// 	console.log("Logout");
		
	// }

	return(
		<section>
			<div><Header /></div>
			
		</section>
	)
}
	

