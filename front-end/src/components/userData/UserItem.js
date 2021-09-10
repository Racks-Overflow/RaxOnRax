import classes from "../trip/TripItem.module.css";

import Card from "../ui/Card";

import { useContext } from "react";

function UserItem(props) {
	// const favoritesCtx = useContext(FavoritesContext);

	// const itemIsFavorite = favoritesCtx.itemIsFavorite(props.id);

	// function toggleFavoriteStatusHandler() {
	// 	if (itemIsFavorite) {
	// 		FavoritesContext.removeFavorite(props.id);
	// 	} else {
	// 		favoritesCtx.addFavorite({
	// 			id: props.id,
	// 			username: props.username,
    //             password:props.password,
    //             appEmail: props.appEmail,
    //             balance: props.balance,
    //             isGoing: props.isGoing,
    //             Role: props.Role,
	// 		});
	// 	}
	// }

	return (
		<li className={classes.item}>
			<Card>
				<div className={classes.content}>
                    <h3>{props.id}</h3>
					<h3>{props.username}</h3>
					<h3>{props.password}</h3>
					<h3>{props.appEmail}</h3>
					<h3>{props.balance}</h3>
					<h3>{props.isGoing}</h3>
					<h3>{props.Role}</h3>
				</div>
				<div className={classes.actions}>
					{/* <button onClick={toggleUserStatusHandler}>
						{userIsGoing ? "Remove from Trip" : "Add to Trip"}
					</button> */}
				</div>
			</Card>
		</li>
	);
}
export default UserItem;