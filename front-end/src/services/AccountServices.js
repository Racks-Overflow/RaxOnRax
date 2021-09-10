import http from "./http-common";



const createAccount =(username, password, appEmail, balance, isGoing, Role) =>{
    return http.create(`base-account/create`,{
        "username": username,
        "password":password,
        "appEmail":appEmail,
        "balance": 0,
        "isGoing":false,
        "role": false,
    });
};

const login =(username, password) => {
    return http.post(`base-account/account-login/${username}/${password}`,{
        username,
        password,
    });
};
const getAllUsers=()=>{
    return http.get(`base-account/account-list`);
};
const findUserById=(userId)=>{
    return http.get(`base-account/find-account-id/${userId}`,{
        userId,
    });
};
const findUserByName = (username)=>{
    return http.get(`base-account/find-account-username/${username}`,{
        username,
    });
};
const updateEmail = (appEmail, userId) => {
    return http.put(`base-account/${userId}/update-account-email/${appEmail}`,{
        userId,
        appEmail,
    });
};
const updateIsGoing = (isGoing, userId) => {
    return http.put(`base-account/${userId}/update-is-going`,{
        userId,
        isGoing,
    });
};
const updateBalance = (balance, userId) => {
    return http.put(`base-account/${userId}/update-balance/${balance}`,{
        userId,
        balance,
    });
};
export default {
    login,
    getAllUsers,
    createAccount,
    updateBalance,
    updateEmail,
    updateIsGoing,
    findUserById,
    findUserByName,
}
// const deleteUser = (userId) => {
//     return http.delete(`${userId}/update-account-username/${username}`,{
//         userId,
//         username,
//     });
// };



