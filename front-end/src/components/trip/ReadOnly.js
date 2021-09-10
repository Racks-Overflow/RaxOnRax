import React from "react";

const ReadOnlyRow = ({ user, handleEditClick, handleDeleteClick }) => {

    
    
  return (
    <tr>
      <td>{user.username}</td>
      <td>{user.balance}</td>
      <td>{user.destination}</td>
      <td>{user.appEmail}</td>
      <td>
        <button
          type="button"
          onClick={(event) => handleEditClick(event, user)}
        >
          Edit
        </button>
        <button type="button" onClick={() => handleDeleteClick(user.id)}>
          Delete
        </button>
      </td>
    </tr>
  );
};

export default ReadOnlyRow;