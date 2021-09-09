/** @format */

import React from "react";
import { render } from "react-dom";
import { NavLink } from "react-router-dom";
import styles from './MainNav.module.css';
import logoHeader from "../../assets/logoleftcropped.jpeg";


function MainNav() {
	return (<div className={styles.navList}>
						<NavLink exact to="/"  className={styles.navListItem} activeClassName="selected">< i class="material-icons"> castle </i>Home</NavLink>
						<NavLink exact to="/account" className={styles.navListItem} ><i class="material-icons"> auto_awesome </i> Account</NavLink>
						<NavLink exact to="/sign-in" className={styles.navListItem}  ><i class="material-icons"> celebration </i>Create Account</NavLink>
						<NavLink exact to="/trips" className={styles.navListItem}  ><i class="material-icons"> beach_access </i>Trips</NavLink>
						<NavLink exact to="/about-us" className={styles.navListItem} ><i class="material-icons"> emoji_people </i>About us</NavLink>
					  	<NavLink exact to="/report-bug" className={styles.navListItem, styles.issue} ><i class="material-icons">alternate_email</i>Contact us</NavLink>

				</div>);
}
export default MainNav;