import { React, useState, useEffect } from "react";
import axios from "axios";
import { NavLink, useNavigate } from "react-router-dom";
import AuthService from "../components/jwt";
import { axiosPublic } from "../common/axiosPublic";
import "../css/login.css";
const LoginForm = () => {
  const navigate = useNavigate();
  const session = JSON.parse(localStorage.getItem("session"));
  useEffect(() => {
    if (session) navigate("/profile");
  }, []);
  const [pro, setPro] = useState({
    email: "",
    password: "",
  });
  //Step 3:
  const onInputChange = (e) => {
    setPro({ ...pro, [e.target.name]: e.target.value });
  };
  const { email, password } = pro;

  const [data, setData] = useState({});
  const fetchInfo = (pro) => {
    console.log(pro);
    axiosPublic.post("auth/login/" + pro.email + "/" + pro.password).then(
      (response) => {
        console.log(response);
        setData(response.client);
        console.log(response.token);
        if (response) {
          localStorage.setItem(
            "session",
            JSON.stringify(response.data["token"])
          );
          localStorage.setItem("user", JSON.stringify(response.data["client"]));
          navigate("/profile", { state: response.data["client"] });
        }
      },
      (error) => {
        console.log(error);
      }
    );
  };
  const [errorMessages, setErrorMessages] = useState({});
  const [isSubmitted, setIsSubmitted] = useState(false);

  const handleSubmit = (e) => {
    //Prevent page reload
    e.preventDefault();
    fetchInfo(pro);

    // Compare user info
    if (data == null) {
      // Invalid password
      setErrorMessages({ name: "pass", message: "invalid password" });
      // Username not found
      setErrorMessages({ name: "uname", message: "invalid user name" });
    }
  };

  // Generate JSX code for error message
  const renderErrorMessage = (name) =>
    name === errorMessages.name && (
      <div className="error">{errorMessages.message}</div>
    );

  // JSX code for login form
  return (
    <div>
      <div className="container-fluid">
        <div className="row main-content bg-success text-center">
          <div className="col-md-4 text-center company__info">
            <span className="company__logo">
              <h2>
                <span className="fa fa-android"></span>
              </h2>
            </span>
            <h4 className="company_title">
              --- BAS --- <br />
              Buy And Sell
            </h4>
          </div>
          <div className="col-md-8 col-xs-12 col-sm-12 login_form ">
            <div className="container-fluid">
              <div className="row">
                <h2>Log In</h2>
              </div>
              <div className="row">
                <form
                  control=""
                  className="form-group"
                  onSubmit={(e) => handleSubmit(e)}
                >
                  <div className="row">
                    <input
                      type="email"
                      name="email"
                      onChange={(e) => onInputChange(e)}
                      id="emailAddress"
                      className="form__input"
                      placeholder="Email"
                      required
                    />{" "}
                    {renderErrorMessage("uname")}
                  </div>
                  <div className="row">
                    <span className="fa fa-lock"></span>
                    <input
                      type="password"
                      name="password"
                      onChange={(e) => onInputChange(e)}
                      id="password"
                      className="form__input"
                      placeholder="Password"
                      required
                    />{" "}
                    {renderErrorMessage("pass")}
                  </div>

                  <div className="row">
                    <input type="submit" value="Submit" className="btn" />
                  </div>
                </form>
              </div>
              <div className="row">
                <p>
                  Don't have an account?{" "}
                  <NavLink to="/registerForm">Register Here</NavLink>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className="container-fluid text-center footer">
        <p>Coded with &hearts; by Alijamaleddine</p>
      </div>
    </div>
  );
};

export default LoginForm;
