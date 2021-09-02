import { Route , Switch} from "react-router-dom";
import Account from "../../pages/Account";
import Home from "../../pages/Home";
import ReportBug from "../../pages/ReportBug";
import SignIn from "../../pages/SignIn";
import Trips from "../../pages/Trip";
import Layout from "./Layout";




export default function Header() {
	return (
		<div>
		<Layout>
			<Switch>
				<Route path="/" exact>
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
			</Switch>
		</Layout>
    </div>
	);
}

