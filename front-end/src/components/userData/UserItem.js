
export default function UserItem(){
return (
    <li className={classes.item}>
        <Card>
            <div className={classes.content}>
                <h3>{props.username}</h3>
                <h3>{props.password}</h3>
                <h3>{props.email}</h3>
                <h3>{props.balance}</h3>
                <h3>{props.isGoing}</h3>
                <h3>{props.role}</h3>
                <h3>{props.adminTrip}</h3>
            </div>
        </Card>
    </li>
);
}
export default UserItem;
// { 
//     "username" : "Mock User",
//     "password" : "passw0rd",
//     "appEmail" : "muser123@gmail.com",
//     "balance"  : 0.00,
//     "isGoing"  : false,
//     "role"  : "ADMIN",
//     "adminTrip" : null    
// }
