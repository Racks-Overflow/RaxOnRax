/** @format */

import React from "react";
import { render } from "react-dom";
import { Link } from "react-router-dom";
import styles from './MainNav.module.css';
import logoHeader from "../../assets/logoleftcropped.jpeg";


function MainNav() {
	return (	<div>
				<nav className={styles.mainNav}>
				<ul className={styles.navList}>
					<li>
					 <Link className={styles.navListItem} to="/home"  >< i class="material-icons"> castle </i>Home</Link>
					</li>
					<li>
						<Link className={styles.navListItem} to="/account" ><i class="material-icons"> auto_awesome </i> Account</Link>
					</li>
					<li className={styles.navListItem}>
						<Link className={styles.navListItem} to="/sign-in" ><i class="material-icons"> celebration </i>Create Account</Link>
					</li>
                    <li>
						<Link  className={styles.navListItem} to="/trips"><i class="material-icons"> beach_access </i>Trips</Link>
					</li>
					<li>
					<Link className={styles.navListItem} to="/about-us" ><i class="material-icons"> emoji_people </i>About us</Link>
					</li>
                    <li>
						<Link  className={styles.navListItem, styles.issue} to="/report-bug"><i class="material-icons"> sentiment_very_dissatisfied </i>Report Bug</Link>
					</li>					
				</ul>
		</nav>

		</div>
	);
}
export default MainNav;