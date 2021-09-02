/** @format */

import classes from "./TripItem.module.css";
import Card from "../../ui/Card";

function TripItem(props) {
	return (
		<li className={classes.item}>
      <Card>
        <div className={classes.image}>
          <img src={props.image} alt={props.title} />
        </div>
        <div className={classes.content}>
          <h3>{props.title}</h3>
          <address>{props.date}</address>
          <p>{props.number}</p>
        </div>
        <div className={classes.actions}>
          <button>To Favorites</button>
        </div>
      </Card>
    </li> 
	);
}
export default TripItem;
