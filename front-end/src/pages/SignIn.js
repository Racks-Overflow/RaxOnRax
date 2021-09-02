import SignInForm from '../components/NewStuff/SignInForm';
import classes from './Page.module.css'
import { useHistory } from 'react-router';


function SignIn(){
    const history = useHistory();

    function signInHandler(userData) {
        fetch(
			'https://stax-67bce-default-rtdb.firebaseio.com/signin.json',
			{
				method: "POST",
				body: JSON.stringify(userData),
				headers: {
					"Content-Type": "application/json",
				},
			}
		).then(() => {
            history.replace('/');
          });
        
	}
    return(
        <section>
            <h1>Please Sign-In</h1>
            <SignInForm onSignIn={signInHandler} />
            
       </section> 
       );
    }

export default SignIn;