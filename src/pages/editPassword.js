import React, { useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AuthService from "../components/jwt";
import {axiosPrivate} from "../common/axiosPrivate";

const EditPassword = () => 
{
 
  const navigate = useNavigate();
  let { state } = useLocation();

  const id1 = state.id;
  //Get the input data
  const [pass, setPass] = useState();
  const [oldpass, setOldPass] = useState();
  //Step 3:
  const onInputPass = (e) => {
    setPass(e.target.value);
  };
  const onInputOldPass = (e) => {
    setOldPass(e.target.value);
  };
  const onInputPassword = (e) => {
    if (e.value === pass) {
      onInputPass(e);
    } else {
      e.value = "";
    }
  };
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
        setPass(passwordInput.cpassword);
        document.getElementById("sub").disabled = false;
      }
    }
  };
  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate
      .post(
        "updateClients/updatePassword" +
          "/" +
          id1 +
          "/" +
          oldpass +
          "/" +
          pass
       
      )
      .then(
        (response) => {
          console.log(response.data);
          if (response.data) {
            console.log("done");

            console.log(response.data);

            navigate("/profile");
          } else alert("Password does not changed , try again later!");
        },
        (error) => {
          console.log(error);
          alert("Operation failed");
        
        }
      );
  };
  return (
    <div>
      <div class="testbox">
        <form onSubmit={(e) => handleSubmit(e)}>
          <div class="banner">
            <h1>Editing Password</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <p>
                Current password<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="password"
                  name="oldpass"
                  onChange={(e) => onInputOldPass(e)}
                  placeholder="Enter first name"
                  required
                />
              </div>
            </div>
          </div>
          <div class="position-item">
            <div class="item">
              <p>
                New password<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="password"
                  name="password"
                  onChange={(e) => {
                    handlePasswordChange(e);
                  }}
                  onKeyUp={(e) => {
                    handleValidation(e);
                  }}
                  placeholder="Enter the new password"
                  required
                />
              </div>
              <p className="text-danger">{passwordError}</p>
            </div>
          </div>
          <div class="position-item">
            <div class="item">
              <p>
                Confirm password<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="password"
                  name="cpassword"
                  onChange={(e) => {
                    handlePasswordChange(e);
                  }}
                  onKeyUp={(e) => {
                    handleValidation(e);
                  }}
                  placeholder="Retype the new password"
                  required
                />
              </div>
              <p className="text-danger">{confirmPasswordError}</p>
            </div>
          </div>

          <div class="position-item">
            <div class="item">
              <button type="submit" href="/">
                Save
              </button>
            </div>

            <button
              onClick={() => {
                navigate(-1);
              }}
            >
              Return to profile
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default EditPassword;
