import axios from "axios";

const BANK_API ="http://localhost3300/bank/";

const create= (accountNum, firstName, lastName, phoneNumber, address) => {
    return axios.create(BANK_API+"create", {
        accountNum,
        firstName,
        lastName,
        phoneNumber,
        address,
    });
};

const findBankAccById =(accountNum) => {
    return axios.get(BANK_API+"bank-account/{accountNum}",{
        accountNum,
    });
};

const updateAccount= (accountNum) => {
    return axios.update(BANK_API+"update/{id}",{
        accountNum,
    });
};

const deleteAccount =(accountNum) => {
    return axios.delete(BANK_API+"delete-bank-acc",{
        accountNum
    });
};

export default {
    findBankAccById,
    updateAccount,
    deleteAccount,
    create,
};