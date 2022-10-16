import React, { useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import AuthService from "../../components/jwt";
import { axiosPrivate } from "../../common/axiosPrivate";
const EditProductType = () => {
  const navigate = useNavigate();
  let { state } = useLocation();

  const id1 = state.id;
  //Get the input data
  const [type, setType] = useState();

  //Step 3:
  const onInputType = (e) => {
    setType(e.target.value);
  };

  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    axiosPrivate.post("productUpdate/updateType/" + id1 + "/" + type).then(
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
            <h1>Editing type of product</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <h5>
                Type of product<span class="required">*</span>
              </h5>
              <select name="type" onChange={(e) => onInputType(e)} required>
                <option value="Vehicules">Vehicules</option>
                <option value="Pets">Pets</option>
                <option value="Electronics">Electronics</option>
                <option value="Properties">Properties</option>
                <option value="Nurritures">Nurritures</option>
              </select>
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
export default EditProductType;
