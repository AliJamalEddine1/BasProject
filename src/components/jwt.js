import axios from "axios";
//import Cookies from "js-cookie";

const API_URL = "http://localhost:9191/";

class AuthService {
  login(e) {
    return axios
      .post(API_URL + "auth/login/" + e.email + "/" + e.password)
      .then((response) => {
        if (response) {
          localStorage.setItem(
            "session",
            JSON.stringify(response.data["token"])
          );
          localStorage.setItem("user", JSON.stringify(response.data["client"]));
          //console.log(response.data["token"] + " this is forbidden");

          //console.log(axios.defaults.headers.common["Authorization"])
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
    localStorage.removeItem("session");
  }

  register(e) {
    return axios
      .post(API_URL + "auth/register", e, { withCredentials: true })
      .then((response) => {
        //  axios.defaults.headers.common["Authorization"] =
        //  "Bearer " + response.data;
        return response.data;
      });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem("session"));
  }
}

export default new AuthService();
