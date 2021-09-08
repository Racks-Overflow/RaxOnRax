import React, {useState, useEffect} from 'react';
import UserServices from '../../services/AccountServices';
import React from 'react'



function UserComponent() {

    const [users, setUsers] = useState([])

    useEffect(() => {
        getUsers()
    }, [input])

    const getUsers = () => {

        UserServices.getUsers().then((response)=> {
            setEmployees(response.data)
            console.log(response.data);
        });
    }

    return (
        <div className="container">

            <h1 className="text-center">User List</h1>
            <table className = "table table-striped">
                
            </table>
            
        </div>
    )
}
export default UserComponent