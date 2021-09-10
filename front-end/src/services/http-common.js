import axios from "axios";

export default axios.create({
  baseURL: "https://stax-overflow.herokuapp.com",
  headers: {
    "Content-type": "application/json"
  }
});