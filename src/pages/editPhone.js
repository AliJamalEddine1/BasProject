import React, { useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AuthService from "../components/jwt";
import { axiosPrivate } from "../common/axiosPrivate";
const EditPhone = () => {
  const navigate = useNavigate();
  let { state } = useLocation();

  const id1 = state.id;
  //Get the input data
  const [phone, setPhone] = useState();

  //Step 3:
  const onInputPhone = (e) => {
    setPhone(e.target.value);
  };

  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate
      .post("updateClients/updatePhoneNumber" + "/" + id1 + "/" + phone)
      .then(
        (response) => {
          console.log(response.data);
          if (response.data) {
            console.log("done");

            state.phoneNumber = phone;
            localStorage.removeItem("user");

            localStorage.setItem("user", JSON.stringify(state));
            console.log(response.data);

            navigate("/profile");
          } else alert("Name does not changed , try again later!");
        },
        (error) => {
          console.log(error);
          alert("Operation failed");
         
        }
      );
  };
  return (
    <div>
      <head>
        <title>Job Application Form</title>
      </head>
      <div class="testbox">
        <form
          onSubmit={(e) => {
            handleSubmit(e);
          }}
        >
          <div class="banner">
            <h1>Editing phone number</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <p>
                Phone Number<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="number"
                  name="phone"
                  onChange={(e) => onInputPhone(e)}
                  placeholder="Enter new phone number"
                  required
                />
              </div>
            </div>
          </div>

          <div class="position-item">
            <div class="item">
              <button type="submit">Save</button>
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
export default EditPhone;
