import React from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";
import AuthService from "../components/jwt";
import { axiosPrivate } from "../common/axiosPrivate";
const EditEmail = () => {
  const navigate = useNavigate();
  const { state } = useLocation();
  const id1 = state.id;
  //Get the input data
  const [lemail, setLemail] = useState();
  const [nemail, setNemail] = useState();
  //Step 3:
  const onInputLEmail = (e) => {
    setLemail(e.target.value);
  };
  const onInputNEmail = (e) => {
    setNemail(e.target.value);
  };
  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate
      .post("updateClients/updateEmail/" + id1 + "/" + lemail + "/" + nemail)
      .then(
        (response) => {
          console.log(response.data);
          if (response.data.id > 0) {
            console.log("done");
            localStorage.removeItem("user");

            localStorage.setItem("user", JSON.stringify(response.data));
            navigate("/profile");
          } else alert("Email is in use,change it");
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
            <h1>Editing Email</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <p>
                Your email<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="email"
                  name="lemail"
                  onChange={(e) => {
                    onInputLEmail(e);
                  }}
                  placeholder="Enter your email"
                  required
                />
              </div>
            </div>
          </div>
          <div class="item">
            <p>
              New email<span class="required">*</span>
            </p>
            <div class="name-item">
              <input
                type="email"
                name="nemail"
                onChange={(e) => {
                  onInputNEmail(e);
                }}
                placeholder="Enter new email"
                required
              />
            </div>
          </div>

          <div class="position-item">
            <div class="item">
              <input type="submit" value="Save" />
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
export default EditEmail;
