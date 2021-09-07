import { Route , Switch} from "react-router-dom";
import Account from "../../pages/Account";
import Home from "../../pages/Home";
import ReportBug from "../../pages/ReportBug";
import SignIn from "../../pages/Login";
import Trips from "../../pages/Trip";
import Layout from "./Layout";
import SignUp from "../../pages/CreateLogin";




export default function Header() {
	return (
		<div>
		<Layout>
			<Switch>
				<Route path="/home" exact>
					<Home />
				</Route>
				<Route path="/report-bug">
					<ReportBug />
				</Route>
				<Route path="/trips">
					<Trips />
				</Route>
				<Route path="/account">
					<Account />
				</Route>
				<Route path="/sign-in">
					<SignIn />
				</Route>
				<Route path="/sign-up">
					<SignUp />
				</Route>
			</Switch>
		</Layout>
    </div>

    
	);
}



