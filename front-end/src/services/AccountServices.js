import axios from 'axios';

const ACCOUNT_URL="http://localhost:3300/base-account/";

const createAccount =(username, password, appEmail, balance, isGoing, Role) =>{
    return axios.create(ACCOUNT_URL+"create",{
        username,
        password,
        appEmail,
        balance,
        isGoing,
        Role,
    });
};

const login =(username, password) => {
    return axios.post(ACCOUNT_URL+"account-login/{username}/{password}",{
        username,
        password,
    });
};
const getAllUsers=()=>{
    return axios.get(ACCOUNT_URL+"account-list");
};
const findUserById=(userId)=>{
    return axios.get(ACCOUNT_URL+"find-account-id/{id}",{
        userId,
    });
};



