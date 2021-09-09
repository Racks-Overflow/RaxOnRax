import { useEffect, useState } from "react";
import UserList from "./UserList";

const mock = [ 
        { 
            id:1,
        username: "Jon Snow",
        password : "ic3br3aker",
        appEmail : "muser123@gmail.com",
        balance  : 230.00,
        isGoing  : false,
        role  : "ADMIN",
        adminTrip : null    
        },
        { 
            id:2,
        username : "Cersei Lannister",
        password : "w1ck3d1",
        appEmail : "muser123@gmail.com",
        balance  : 1000.00,
        isGoing  : false,
        role  : "ADMIN",
        adminTrip : null    
        },
        { 
            id:3,
        username : "Celica Limbert",
        password : "passwh0rds",
        appEmail : "muser123@gmail.com",
        balance  : 50.00,
        isGoing  : false,
        role : "ADMIN",
        adminTrip : null    
        },
        { id:4,
        username : "Arya Stark",
        password : "n33dle14",
        appEmail : "muser123@gmail.com",
        balance  : 17.00,
        isGoing  : false,
        role  : "ADMIN",
        adminTrip : null    
        }
    ]

function UserComponent() {
    

	const [isLoading, setIsLoading] = useState(true);
	const [loadedUsers, setLoadedUsers] = useState([]);

	useEffect(() => {
    setIsLoading(true);
		fetch("http://localhost:8080/base-account/account-list")
			.then((response) => {
				return response.json();
			})
			.then((data) => {
        const users = [];

        for(const key in data){
          const user={
            id: key,
            ...data[key]
          };
          users.push(user);
        }
				setIsLoading(false);
				setLoadedUsers(data);
			});
	}, []);

	if (isLoading) {
		return (
			<section>
				<p> Loading...</p>
			</section>
		);
	}

	return (
		<section>
			<h1>All Users</h1>
			<UserList users={loadedUsers} />
		</section>
	);
}

export default UserComponent;