import classes from "../trip/TripList.module.css";
import UserItem from "./UserItem";

function UserList(props) {
	return (
		<ul className={classes.list}>
			{props.users.map((user) => (
				<UserItem
					key={user.id}
					username={user.username}
					appEmail={user.appEmail}
					balance={user.balance}
					isGoing={user.isGoing}
					Role={user.Role}
				/>
			))}
		</ul>
	);
}

export default UserList;