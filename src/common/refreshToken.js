import mem from "mem";
import { useNavigate, Navigate } from "react-router-dom";
import { axiosPublic } from "./axiosPublic";

const refreshTokenFn = async () => {
//const navigate=useNavigate();
  console.log(localStorage.getItem("user"));
  const email = JSON.parse(localStorage.getItem("user")).email;
  const user = email;
  console.log(user);
  try {
    const response = await axiosPublic.post("auth/refresh", user);
    console.log(response.data);
    const session = response.data;
    console.log(session);
    console.log(user);
    if (!session) {
      localStorage.removeItem("session");
      localStorage.removeItem("user");
    }

    localStorage.setItem("session", JSON.stringify(session));

    return session;
  } catch (error) {
    console.log("erroeeeeeeeeeeee");
    localStorage.removeItem("session");
    localStorage.removeItem("user");
    <Navigate to="/login"/>;
  }
};
const maxAge = 10000;

export const memoizedRefreshToken = mem(refreshTokenFn, {
  maxAge,
});
