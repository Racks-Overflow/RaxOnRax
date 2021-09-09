import http from "./http-common";



const create= (accountNum, firstName, lastName, phoneNumber, address) => {
    return axios.create("bank/create", {
        accountNum,
        firstName,
        lastName,
        phoneNumber,
        address,
    });
};

const findBankAccById =(accountNum) => {
    return http.get(`bank/bank-account/${accountNum}`,{
        accountNum,
    });
};

const updateAccount= (accountNum) => {
    return http.update(`bank/update/${accountNum}`,{
        accountNum,
    });
};

const deleteAccount =(accountNum) => {
    return http.delete(`bank/delete-bank-acc`,{
        accountNum
    });
};

export default {
    findBankAccById,
    updateAccount,
    deleteAccount,
    create,
};