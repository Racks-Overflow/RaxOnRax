import classes from "./TripList.module.css";
import UserItem from "./UserItem";

function UserList(props) {
	return (
		<ul className={classes.list}>
			{props.users.map((user) => (
				<UserItem
					key={user.id}
					id={user.id}
					username={user.username}
					password={user.password}
					appEmail={user.appEmail}
					balance={user.balance}
					isGoing={user.isGoing}
					role={user.role}
					adminTrip={user.adminTrip}
				/>
			))}
		</ul>
	);
}

export default UserList;