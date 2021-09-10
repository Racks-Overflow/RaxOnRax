import * as React from 'react';
import { DataGrid } from '@material-ui/data-grid';
import classes from './Invite.module.css'
import UserList from '../userData/UserList';
import { useState, useEffect } from 'react';
import UserItem from '../userData/UserItem';


const columns = [
  { field: 'staxId', headerName: 'ID', width: 90 },
  {
    field: 'username',
    headerName: 'User',
    width: 150,
    editable: true,
  },
  {
    field: 'balance',
    headerName: 'Balance',
    width: 150,
    editable: true,
  },
  {
    field: 'destination',
    headerName: 'user',
    width: 110,
    editable: true,
  },
  {
    field: 'appEmail',
    headerName: 'Email',
    width: 110,
    editable: true,
  },
  {
    field: 'user',
    headerName: 'user',
    width: 110,
    editable: true,
  },
  {
    field: 'role',
    headerName: 'Admin',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
  },
  {
    field: 'adminuser',
    headerName: 'Admin',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
  },
  {
    field: 'account',
    headerName: 'Admin',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
  },
  {
    field: 'activeuser',
    headerName: 'Admin',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
  },{
    field: 'going',
    headerName: 'Admin',
    description: 'This column has a value getter and is not sortable.',
    sortable: false,
    width: 160,
  }
];

export default function Invite(props) {
  

	const [isLoading, setIsLoading] = useState(true);
	const [loadedUsers, setLoadedUsers] = useState([]);

	useEffect(() => {
    setIsLoading(true);
		fetch("https://stax-overflow.herokuapp.com/tripcontroller")
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
				setLoadedUsers(data );
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
    <div style={{ height: 400, width: '100%' }}>
      <DataGrid
        rows={loadedUsers.map((user) => (
          <UserItem
            key={user.id}
            id={user.id}
            destination={user.destination}
            gropuSize={user.groupSize}
            userEstimate={user.userEstimate}
            balance={user.balance}
            totalSpent={user.totalSpent}
            estimatePerPerson={user.estimatePerPerson}
            isActive={user.isActive}
            
          />
        ))}
        columns={columns}
        pageSize={5}
        checkboxSelection
        disableSelectionOnClick
      />
    </div>
  );
}
