import axios from 'axios';

const USERS_REST_API_URL="http://localhost:3300/base-account/create";

class UserServcie{

    getUsers(){
        return axios.get(USERS_REST_API_URL)
    }
}
export default new CreateUser();