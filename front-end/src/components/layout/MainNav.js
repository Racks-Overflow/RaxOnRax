/** @format */

import React from "react";
import { Link } from "react-router-dom";
import classes from './MainNav.module.css';







function MainNav() {
	return (
		<header>
			<div ><img className={classes.pic} src= "https://github.com/Racks-Overflow/RaxOnRax/blob/newDev/front-end/public/mainlogodark.png?raw=true" alt="logo" /></div>
			<nav>
				<ul>
					<li>
					 <Link to="/home"className ={classes.home} >< i class="material-icons"> castle </i>Home</Link>
					</li>
                    <li>
						<Link to="/trips" className= {classes.trip}><i class="material-icons"> beach_access </i>Trips</Link>
					</li>
                    <li>
						<Link to="/account" className= {classes.personal}><i class="material-icons"> auto_awesome </i> Account</Link>
					</li>
                    <li>
						<Link to="/report-bug" className={classes.issue}><i class="material-icons"> sentiment_very_dissatisfied </i>Report Bug</Link>
					</li>
                    <li>
						<Link to="/sign-in" className= {classes.join}><i class="material-icons"> celebration </i>Create Account</Link>
					</li>
					<li>
					<Link to="/about-us" className= {classes.about}><i class="material-icons"> emoji_people </i></Link>
					</li>
				</ul>
			</nav>
		</header>
	);
}
export default MainNav;