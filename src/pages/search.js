import React, { useState, useEffect, async } from "react";
import { NavLink, Routes, Route, useNavigate } from "react-router-dom";
import axios from "axios";
import Detail from "./detail";
import { axiosPrivate } from "../common/axiosPrivate";

const Search = ({ val }) => {
  const [products, setProducts] = useState([]);
 
  
  useEffect(() => {
    fetchProducts();
  }, []);
 
  const fetchProducts = () => {
    axiosPrivate
      .get("searchProducts/search/" + val)
      .then((res) => {
        console.log(res);
       
        setProducts(res.data);
     
      })
      .catch((err) => {
        console.log(err);
        navigate("/login");
      });
  };

  //const body = response.json();

  //setProducts({ body });

  const navigate = useNavigate();

  return (
    <div class="row tm-mb-90 tm-gallery">
      {products.map((product) => (
        <div
          className="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5"
          key={product.id}
        >
          <figure className="effect-ming tm-video-item">
            <img
              src={`data:${
                product.fileType
              };base64,
              ${product.data}`}
              alt="Imag"
              className="img-fluid"
            />

            <figcaption className="d-flex align-items-center justify-content-center">
              <h2>{product.type}</h2>

              <NavLink to="/productDetails" state={{ product }}>
                details
              </NavLink>
            </figcaption>
          </figure>
          <div className="d-flex justify-content-between tm-text-gray">
            <span className="tm-text-gray-light">{product.quantity}</span>
            <span>{product.description}</span>
          </div>
        </div>
      ))}
    </div>
  );
};
export default Search;
