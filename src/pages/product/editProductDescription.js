import React, { useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AuthService from "../../components/jwt";
import { axiosPrivate } from "../../common/axiosPrivate";
const EditProductDescription = () => {
  const navigate = useNavigate();
  let { state } = useLocation();

  const id1 = state.id;
  //Get the input data
  const [desc, setDesc] = useState();

  //Step 3:
  const onInputChange = (e) => {
    setDesc(e.target.value);
  };

  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate.post("productUpdate/updateDescription/" + id1 + "/" + desc).then(
      (response) => {
        console.log(response.data);
        if (response.data) {
          console.log("done");

          console.log(response.data);

          navigate(-1);
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
        <form
          onSubmit={(e) => {
            handleSubmit(e);
          }}
        >
          <div class="banner">
            <h1>Editing description of product</h1>
          </div>

          <div class="position-item">
          <div class="item">
            <h5>
              Description<span class="required">*</span>
            </h5>
            <textarea
              type="text"
              name="description"
              style={{ width: "600px" }}
              rows="5"
              placeholder="Enter product description"
              onChange={(e) => onInputChange(e)}
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
              Return
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default EditProductDescription;
