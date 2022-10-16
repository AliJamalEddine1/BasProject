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
  const [img, setImg] = useState({});

  //Step 3:

  const formData = new FormData();
  const fileChangedHandler = (e) => {
    e.preventDefault();
    const file = e.target.files[0];
    setImg(file);
  };

  //Submit data
  const handleSubmit = (data) => {
    data.preventDefault();
    console.log(id1);
    const formData = new FormData();
    formData.append("file", img);
    axiosPrivate
      .post("image/update/" + id1, formData, {
        headers: { "Content-Type": "multipart/form-data" },
      })
      .then(
        (response) => {
          console.log(response.data);
          if (response.data) {
            console.log("done");

            console.log(response.data);

            navigate(-1);
          } else alert(" does not changed , try again later!");
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
            <h1>Editing image of product</h1>
          </div>

          <div class="position-item">
            <div class="item">
              <h5>Upload image:</h5>
              <input
                type="file"
                name="image"
                accept="image/*"
                onChange={(e) => {
                  fileChangedHandler(e);
                }}
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
export default EditProductType;
