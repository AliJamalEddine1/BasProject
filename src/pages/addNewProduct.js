import { React, useState, useEffect } from "react";
//import axios from "axios";
import AuthService from "../components/jwt";
import { axiosPrivate } from "../common/axiosPrivate";
import "../css/newProduct.css";
const AddProduct = ({ id }) => {
  //Step 1:
  const [pro, setPro] = useState({
    description: "",
    image: "",
    location: "",
    price: "",
    quantity: "1",
    type: "Vehicules",
    yearOf: "",
    clientId: id,
    forSearch: "",
  });
  //Step 3:
  const onInputChange = (e) => {
    setPro({ ...pro, [e.target.name]: e.target.value });
  };
  const {
    description,
    image,
    location,
    price,
    quantity,
    type,
    yearOf,
    clientId,
  } = pro;

  const FormHandle = (e) => {
    setPro({
      ...pro,
      forSearch:
        " " +
        description +
        " " +
        location +
        " " +
        type +
        " " +
        quantity +
        " " +
        price +
        " " +
        yearOf,
    });
    e.preventDefault();
    addDataToServer(pro);
  };
  const [img, setImg] = useState({});
  const formData = new FormData();
  const fileChangedHandler = (e) => {
    e.preventDefault();
    const file = e.target.files[0];
    setImg(file);
  };
  const [res, setRes] = useState({});
  const addDataToServer = (data) => {
    axiosPrivate.post("products/addnewproduct", data).then(
      (response) => {
        const inf = response.data;
        const formData = new FormData();
        formData.append("file", img);
        const result = axiosPrivate.post(
          "image/upload/" + inf.id + "/" + inf.clientId,
          formData,
          {
            headers: { "Content-Type": "multipart/form-data" },
          }
        );
        console.log(response);
        alert("product Added Successfully");
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
        <form action="/" method="POST" onSubmit={(e) => FormHandle(e)}>
          <div class="banner">
            <h1>Adding new product</h1>
          </div>
          <div class="position-item">
            <div class="item">
              <p>
                Type of product<span class="required">*</span>
              </p>
              <select name="type" onChange={(e) => onInputChange(e)} required>
                <option value="Vehicules">Vehicules</option>
                <option value="Pets">Pets</option>
                <option value="Electronics">Electronics</option>
                <option value="Properties">Properties</option>
                <option value="Nurritures">Nurritures</option>
              </select>
            </div>
            <div class="item">
              <p>
                Quantity<span class="required">*</span>
              </p>
              <select
                name="quantity"
                onChange={(e) => onInputChange(e)}
                required
              >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="5"> &gt;5 </option>
              </select>
            </div>
          </div>
          <div class="position-item">
            <div class="item">
              <p>
                Price in USDT<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="number"
                  min="1"
                  step="1"
                  placeholder="Enter product price"
                  name="price"
                  onChange={(e) => onInputChange(e)}
                  required
                />
              </div>
            </div>
            <div class="item">
              <p>
                Location<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="text"
                  name="location"
                  placeholder="Enter product location"
                  onChange={(e) => onInputChange(e)}
                  required
                />
              </div>
            </div>
          </div>
          <div class="position-item">
            <div class="item">
              <p>
                Year of production<span class="required">*</span>
              </p>
              <div class="name-item">
                <input
                  type="year"
                  name="yearOf"
                  placeholder="Enter the year of production"
                  onChange={(e) => onInputChange(e)}
                  required
                />
              </div>
            </div>
            <div class="item">
              <p>Upload image:</p>
              <input
                type="file"
                name="image"
                accept="image/*"
                onChange={(e) => {
                  fileChangedHandler(e);
                  onInputChange(e);
                }}
                required
              />
            </div>
          </div>
          <div class="item">
            <p>
              Description<span class="required">*</span>
            </p>
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

          <div class="btn-block">
            <button type="submit" href="/">
              Add Product
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default AddProduct;
