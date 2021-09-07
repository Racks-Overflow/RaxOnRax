import axios from 'axios';

const ACCOUNT_URL="http://localhost:3300/base-account/";

class UserServcie{

    getUsers(){
        return axios.get(USERS_REST_API_URL)
    }
}
export default new CreateUser();