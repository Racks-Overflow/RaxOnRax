import React, {useState} from "react";

export default function ManageTrips(){
    const [users, setUsers] = useState(users);

    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>staxId</th>
                        <th>User Name</th>
                        <th>Trip</th>
                        <th>Balance</th>
                        <th>actions</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user)=>(
                    <tr>
                        <td>{user.staxId}</td>
                        <td>{user.username}</td>
                        <td>{user.trip}</td>
                        <td>{user.appEmail}
                        <td>{user.balance}</td> 
                        <td><button/><button/><button/></td>
                    </tr>
                    ))}
                </tbody>
            </table>
            <h2>
                Add User To Trip
            </h2>
            <form>
                <input
                type="text"
                name="fullName"
                required=""
                placeholder="Enter Username"
                />
            </form>
        </div>
    )
}
