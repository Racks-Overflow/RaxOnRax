import axios from "axios";


//this is what needs to be changed in order to launch npm 

export default axios.create({
  baseURL: "https://stax-overflow.herokuapp.com",
    // "https://stax-overflow.herokuapp.com",
  headers: {
    "Content-type": "application/json"
  }
});