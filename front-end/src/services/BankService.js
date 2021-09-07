import axios from "axios";

const BANK_API ="http://localhost3300/bank/";

const create= (accountNum, firstName, lastName, phoneNumbeer, address) => {
    return axios.create(BANK_API+"create", {
        accountNum,
        firstName,
        lastName,
        phoneNumber,
        address,
    });
};

const findAccountById =(accountNum) => {
    return axios.get(BANK_API+"/bank-account/{accountNum}");
}
const updateAccount= (accountNum) => {
    return axios.update
}