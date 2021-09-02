/** @format */

import React from "react";
import { Link } from "react-router-dom";
import classes from './MainNav.module.css';




function MainNav() {
	return (
		<header className={classes.header}>
			<div className={classes.logo}><img className={classes.img} src="https://cdn.discordapp.com/attachments/862694659306029118/880950104960430111/Screen_Shot_2021-08-27_at_4.59.06_PM.png" alt="logo" /></div>
			<nav>
				<ul>
					<li>
						<Link to="/">Home</Link>
					</li>
                    <li>
						<Link to="/trips">Trips</Link>
					</li>
                    <li>
						<Link to="/account">Account</Link>
					</li>
                    <li>
						<Link to="/report-bug">Report Bug</Link>
					</li>
                    <li>
						<Link to="/sign-in">Sign-In</Link>
					</li>
				</ul>
			</nav>
		</header>
	);
}
export default MainNav;