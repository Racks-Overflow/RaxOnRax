import React, {Fragment, useState} from "react";
import EditableRow from "./EditData";
import ReadOnlyRow from "./ReadOnly";

export default function ManageTrips(){
    const [users, setUsers] = useState(users);
    const [addFormData, setAddFormData] = useState({
    username: "",
    balance: 0,
    email: "",
  });

 const travellers=(
     fetch(`http://localhost:8080/tripcontroller/{id}/get-guests`)
     .then((response) => {
        return response.json();
    })
    .then((data) => {
        const users = []; 
    }))
    

  const [editFormData, setEditFormData] = useState({
    username: "",
    balance: 0,
    
    email: "",
    });

  const [editUserId, setEditUserId] = useState(null);

  const handleAddFormChange = (event) => {
    event.preventDefault();

    const fieldName = event.target.getAttribute("name");
    const fieldValue = event.target.value;

    const newFormData = { ...addFormData };
    newFormData[fieldName] = fieldValue;

    setAddFormData(newFormData);
    };

  const handleEditFormChange = (event) => {
    event.preventDefault();

    const fieldName = event.target.getAttribute("name");
    const fieldValue = event.target.value;

    const newFormData = { ...editFormData };
    newFormData[fieldName] = fieldValue;

    setEditFormData(newFormData);
  };

  const handleAddFormSubmit = (event) => {
    event.preventDefault();

    const newUser = {
      username: addFormData.username,
      balance: addFormData.balance,
      
      email: addFormData.appEmail,
    };

    const newUsers = [...users, newUser];
    setUsers(newUsers);
  };

  const handleEditFormSubmit = (event) => {
    event.preventDefault();

    const editedUser = {
      id: editUserId,
      username: editFormData.username,
      balance: editFormData.balance,
      email: editFormData.appEmail,
    };

    const newUsers = [...users];

    const index = users.findIndex((user) =>user.id === editUserId);

    newUsers[index] = editedUser;

    setUsers(newUsers);
    setEditUserId(null);
  };

  const handleEditClick = (event, user) => {
    event.preventDefault();
    setEditUserId(user.id);

    const formValues = {
      username:user.username,
      balance:user.balance,
      email:user.appEmail,
    };

    setEditFormData(formValues);
  };

  const handleCancelClick = () => {
    setEditUserId(null);
  };

  const handleDeleteClick = (userId) => {
    const newUser = [...users];

    const index = users.findIndex((users) => users.id === userId);

    newUser.splice(index, 1);

    setUsers(newUser);
  };


  return (
    <div className="app-container">
      <form onSubmit={handleEditFormSubmit}>
        <table>
          <thead>
            <tr>
              <th>Username</th>
              <th>Trip</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <Fragment>
                {editUserId === user.id ? (
                  <EditableRow
                    editFormData={editFormData}
                    handleEditFormChange={handleEditFormChange}
                    handleCancelClick={handleCancelClick}
                  />
                ) : (
                  <ReadOnlyRow
                    user={user}
                    handleEditClick={handleEditClick}
                    handleDeleteClick={handleDeleteClick}
                  />
                )}
              </Fragment>
            ))}
          </tbody>
        </table>
      </form>

      <h2>Add a Contact</h2>
      <form onSubmit={handleAddFormSubmit}>
        <input
          type="text"
          name="fullName"
          required="required"
          placeholder="Enter a name..."
          onChange={handleAddFormChange}
        />
        <input
          type="text"
          name="address"
          required="required"
          placeholder="Enter an addres..."
          onChange={handleAddFormChange}
        />
        <input
          type="text"
          name="phoneNumber"
          required="required"
          placeholder="Enter a phone number..."
          onChange={handleAddFormChange}
        />
        <input
          type="email"
          name="email"
          required="required"
          placeholder="Enter an email..."
          onChange={handleAddFormChange}
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};