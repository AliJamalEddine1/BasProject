import axios from "axios";
import { Navigate, useNavigate } from "react-router-dom";
import { memoizedRefreshToken } from "./refreshToken";

axios.defaults.baseURL = "http://localhost:9191/";
//const navigate =()=>{ useNavigate();}
axios.interceptors.request.use(
  async (config) => {
    const session = JSON.parse(localStorage.getItem("session"));
    // console.log(session + "                               Ali");
    if (session) {
      config.headers = {
        ...config.headers,
        Authorization: session,
      };
    }
    //  else(axios.URL=='http://localhost:9191/products'){}

    return config;
  },
  (error) => {
    Promise.reject(error);
  }
);

axios.interceptors.response.use(
  (response) => response,
  async (error) => {
    const config = error?.config;
    console.log(config.sent);
    if (error.response.status === 400 || !config.sent) {
      config.sent = true;

      console.log("inside 400");
      const result = await memoizedRefreshToken();

      if (result) {
        config.headers = {
          ...config.headers,
          Authorization: result,
        };
      }
      return axios(config);
    }

    return Promise.reject(error);
  }
);
export const axiosPrivate = axios;
