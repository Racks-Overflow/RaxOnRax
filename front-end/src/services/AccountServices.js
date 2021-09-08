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
    return axios.post(ACCOUNT_URL+"account-login/"+username+"/"+password,{
        username,
        password,
    });
};
const getAllUsers=()=>{
    return axios.get(ACCOUNT_URL+"account-list");
};
const findUserById=(userId)=>{
    return axios.get(ACCOUNT_URL+"find-account-id/"+userId,{
        userId,
    });
};
const findUserByName = (username)=>{
    return axios.get(ACCOUNT_URL+"find-account-username/"+username,{
        username,
    });
};
const updateEmail = (appEmail, userId) => {
    return axios.put(ACCOUNT_URL+userId+"/update-account-email/"+appEmail,{
        userId,
        appEmail,
    });
};
const updateIsGoing = (isGoing, userId) => {
    return axios.put(ACCOUNT_URL+userId+"/update-is-going",{
        userId,
        isGoing,
    });
};
const updateBalance = (balance, userId) => {
    return axios.put(ACCOUNT_URL+ userId+ "/update-balance/"+balance,{
        userId,
        balance,
    });
};
export default {
    updateBalance,
    updateEmail,
    updateIsGoing,
    findUserById,
    findUserByName,
}
// const deleteUser = (userId) => {
//     return axios.put(ACCOUNT_URL+"{id}/update-account-username/{username}",{
//         userId,
//         username,
//     });
// };


