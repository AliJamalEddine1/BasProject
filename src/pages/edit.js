import React, { useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AuthService from "../components/jwt";
import { axiosPrivate } from "../common/axiosPrivate";

const EditName = () => {
  const navigate = useNavigate();
  let { state } = useLocation();
  //
  const id1 = state.id;
  //Get the input data
  const [fname, setFname] = useState();
  const [lname, setLname] = useState();
  //Step 3:
  const onInputFname = (e) => {
    setFname(e.target.value);
  };
  const onInputLname = (e) => {
    setLname(e.target.value);
  };
  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate
      .post("updateClients/updateName" + "/" + id1 + "/" + fname + "/" + lname)
      .then(
        (response) => {
          console.log(response.data);
          if (response.data) {
            console.log("done");
          
            state.firstName = fname;
            state.lastName = lname;
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
      <div class="testbox">
        <form onSubmit={(e) => handleSubmit(e)}>
          <div class="banner">
            <h1>Editing Name</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <p>
                First Name<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="text"
                  name="fname"
                  placeholder="Enter first name"
                  onChange={(e) => onInputFname(e)}
                  required
                />
              </div>
            </div>
          </div>
          <div class="item">
            <p>
              Last Name<span class="required">*</span>
            </p>
            <div class="name-item">
              <input
                type="text"
                name="lname"
                placeholder="Enter last name"
                onChange={(e) => onInputLname(e)}
                required
              />
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
export default EditName;
