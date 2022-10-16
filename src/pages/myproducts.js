import React, { useState, useEffect, async } from "react";
import { NavLink, Routes, Route, useNavigate } from "react-router-dom";
import axios from "axios";
import Detail from "./detail";
import { axiosPrivate } from "../common/axiosPrivate";

const MyProducts = ({ id }) => {
  const [products, setProducts] = useState([]);
  const [data, setData] = useState([]);
  const [img, setImg] = useState([]);
  useEffect(() => {
    fetchProducts();
    axiosPrivate
      .get("image/getImages/" + id)
      .then((res) => {
        setImg(res.data);
        console.log(res);
      })
      .catch((error) => {
        console.log("cannot download img");
      });
  }, []);
  const [loading, setLoading] = useState(true);
  const fetchProducts = () => {
    axiosPrivate
      .get("searchProducts/searchClientID/" + id)
      .then((res) => {
        console.log(res);
        setLoading(false);
        setProducts(res.data);
        setData(res.data);
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
                img.find((imge) => imge.productId == product.id)?.fileType
              };base64,
              ${img.find((imge) => imge.productId == product.id)?.data}`}
              alt="Imag"
              className="img-fluid"
            />

            <figcaption className="d-flex align-items-center justify-content-center">
              <h2>{product.type}</h2>

              <NavLink to="/detail" state={{ product }}>
                edit
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
export default MyProducts;
