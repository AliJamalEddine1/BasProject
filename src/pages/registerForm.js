import "../css/register.css";
import React from "react";
import { useNavigate, NavLink } from "react-router-dom";
import Navigation from "./navigation";
import ProductsList from "../components/ProductsList";
import { useState, useEffect } from "react";
import { axiosPublic } from "../common/axiosPublic";
import AuthService from "../components/jwt";
const RegisterForm = () => {
  const navigate = useNavigate();
  const session = JSON.parse(localStorage.getItem("session"));
  useEffect(() => {
    if (session) navigate("/profile");
  }, []);

  const [pro, setPro] = useState({
    id: "",
    birthday: "",
    email: "",
    firstName: "",
    gender: "",
    lastName: "",
    phoneNumber: "",
    password: "",
  });
  //Step 3:
  const onInputChange = (e) => {
    setPro({ ...pro, [e.target.name]: e.target.value });
  };

  const onInputPassword = (e) => {
    if (e.value === pro.password) {
      onInputChange(e);
    } else {
      e.value = "";
    }
  };
  const {
    birthday,
    email,
    firstName,
    gender,
    lastName,
    phoneNumber,
    password,
  } = pro;
  // password validation
  const [passwordError, setPasswordErr] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");
  const [passwordInput, setPasswordInput] = useState({
    password: "",
    confirmPassword: "",
  });
  const handlePasswordChange = (evnt) => {
    const passwordInputValue = evnt.target.value.trim();
    const passwordInputFieldName = evnt.target.name;
    const NewPasswordInput = {
      ...passwordInput,
      [passwordInputFieldName]: passwordInputValue,
    };
    setPasswordInput(NewPasswordInput);
  };
  const handleValidation = (evnt) => {
    const passwordInputValue = evnt.target.value.trim();
    const passwordInputFieldName = evnt.target.name;
    //for password
    if (passwordInputFieldName === "password") {
      const uppercaseRegExp = /(?=.*?[A-Z])/;
      const lowercaseRegExp = /(?=.*?[a-z])/;
      const digitsRegExp = /(?=.*?[0-9])/;
      const specialCharRegExp = /(?=.*?[#?!@$%^&*-])/;
      const minLengthRegExp = /.{8,}/;
      const passwordLength = passwordInputValue.length;
      const uppercasePassword = uppercaseRegExp.test(passwordInputValue);
      const lowercasePassword = lowercaseRegExp.test(passwordInputValue);
      const digitsPassword = digitsRegExp.test(passwordInputValue);
      const specialCharPassword = specialCharRegExp.test(passwordInputValue);
      const minLengthPassword = minLengthRegExp.test(passwordInputValue);
      let errMsg = "";
      if (passwordLength === 0) {
        errMsg = "Password is empty";
      } else if (!uppercasePassword) {
        errMsg = "At least one Uppercase";
      } else if (!lowercasePassword) {
        errMsg = "At least one Lowercase";
      } else if (!digitsPassword) {
        errMsg = "At least one digit";
      } else if (!specialCharPassword) {
        errMsg = "At least one Special Characters";
      } else if (!minLengthPassword) {
        errMsg = "At least minumum 8 characters";
      } else {
        errMsg = "";
      }
      setPasswordErr(errMsg);
    }
    // for confirm password
    if (
      passwordInputFieldName === "cpassword" ||
      (passwordInputFieldName === "password" &&
        passwordInput.cpassword.length > 0)
    ) {
      if (passwordInput.cpassword !== passwordInput.password) {
        setConfirmPasswordError("Confirm password is not matched");
        document.getElementById("sub").disabled = true;
      } else {
        setConfirmPasswordError("");
        setPro({ ...pro, password: passwordInput.cpassword });
        document.getElementById("sub").disabled = false;
      }
    }
  };
  //
  const FormHandle = (e) => {
    e.preventDefault();
    addDataToServer(pro);
  };

  const addDataToServer = (e) => {
    axiosPublic.post("auth/register", e).then(
      (response) => {
        if (response) {
          console.log("registred");
          navigate("/login");

          window.location.reload();
        }
      },
      (error) => {
        const resMessage =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();
      }
    );
  };
  return (
    <section class="container-fluid tm-container-content tm-mt-60 ">
      <div class="container py-5 h-100 gradient-custom">
        <div class="row justify-content-center align-items-center h-100">
          <div class="col-12 col-lg-9 col-xl-7">
            <div class="card shadow-2-strong card-registration">
              <div class="card-body p-4 p-md-5">
                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Welcome to BAS</h3>
                <form onSubmit={(e) => FormHandle(e)}>
                  <div class="row">
                    <div class="col-md-6 mb-4">
                      <div class="form-outline">
                        <input
                          type="text"
                          name="firstName"
                          class="form-control form-control-lg"
                          onChange={(e) => onInputChange(e)}
                          required
                        />
                        <label class="form-label" for="firstName">
                          First Name
                        </label>
                      </div>
                    </div>
                    <div class="col-md-6 mb-4">
                      <div class="form-outline">
                        <input
                          type="text"
                          name="lastName"
                          onChange={(e) => onInputChange(e)}
                          class="form-control form-control-lg"
                          required
                        />
                        <label class="form-label" for="lastName">
                          Last Name
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 mb-4 d-flex align-items-center">
                      <div class="form-outline datepicker w-100">
                        <input
                          type="date"
                          class="form-control form-control-lg"
                          name="birthday"
                          onChange={(e) => onInputChange(e)}
                          required
                        />
                        <label for="birthdayDate" class="form-label">
                          Birthday
                        </label>
                      </div>
                    </div>
                    <div class="col-md-6 mb-4">
                      <h6 class="mb-2 pb-1">Gender: </h6>

                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="gender"
                          id="femaleGender"
                          value="female"
                          onChange={(e) => onInputChange(e)}
                        />
                        <label class="form-check-label" for="femaleGender">
                          Female
                        </label>
                      </div>

                      <div class="form-check form-check-inline">
                        <input
                          class="form-check-input"
                          type="radio"
                          name="gender"
                          onChange={(e) => onInputChange(e)}
                          id="maleGender"
                          value="male"
                        />
                        <label class="form-check-label" for="maleGender">
                          Male
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 mb-4 pb-2">
                      <div class="form-outline">
                        <input
                          type="email"
                          id="emailAddress"
                          name="email"
                          onChange={(e) => onInputChange(e)}
                          class="form-control form-control-lg"
                          required
                        />
                        <label class="form-label" for="emailAddress">
                          Email
                        </label>
                      </div>
                    </div>
                    <div class="col-md-6 mb-4 pb-2">
                      <div class="form-outline">
                        <input
                          type="number"
                          name="phoneNumber"
                          onChange={(e) => onInputChange(e)}
                          class="form-control form-control-lg"
                          required
                        />
                        <label class="form-label" for="phoneNumber">
                          Phone Number
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 mb-4">
                      <div class="form-outline">
                        <input
                          type="password"
                          id="p1"
                          class="form-control form-control-lg"
                          name="password"
                          onChange={(e) => {
                            handlePasswordChange(e);
                          }}
                          onKeyUp={(e) => {
                            handleValidation(e);
                          }}
                          required
                        />
                        <label class="form-label" for="form3Example4c">
                          Password
                        </label>
                        <p className="text-danger">{passwordError}</p>
                      </div>
                    </div>
                    <div class="col-md-6 mb-4">
                      <div class="form-outline">
                        <input
                          type="password"
                          id="p2"
                          name="cpassword"
                          onChange={(e) => {
                            handlePasswordChange(e);
                          }}
                          onKeyUp={(e) => {
                            handleValidation(e);
                          }}
                          class="form-control form-control-lg"
                        />
                        <label class="form-label" for="form3Example4cd">
                          Repeat your password
                        </label>
                        <p className="text-danger">{confirmPasswordError}</p>
                      </div>
                    </div>
                  </div>
                  <div class="form-check form-check-inline">
                    <input
                      class="form-check-input me-2"
                      type="checkbox"
                      value=""
                      id="privacy"
                      required
                    />
                    <label class="form-check-label" for="form2Example3">
                      I agree all statements in{" "}
                      <a href="#!">Terms of service</a>
                    </label>
                  </div>
                  <div class="mt-4 pt-2">
                    <input
                      class="btn btn-primary btn-lg"
                      type="submit"
                      value="Submit"
                      id="sub"
                    />
                  </div>
                  Have an account?
                  <NavLink to="/login">Login here.</NavLink>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
//const del = document.getElementById("del");

//document.getElementById("flex").removeChild(del);

//document.getElementById("flex").appendChild("Its work");

export default RegisterForm;
