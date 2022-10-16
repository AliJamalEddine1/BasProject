import React, { state, useState, useEffect } from "react";
import { NavLink, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import { axiosPrivate } from "../common/axiosPrivate";
const Detail = () => {
  useEffect(() => {
    fetchProducts();
  }, []);
  const navigate = useNavigate();
  const [image, setImage] = useState();
  const [x, setX] = useState("");
  const location = useLocation();
  const pro = location.state.product;
  const fetchProducts = () => {
    axiosPrivate
      .get("image/getImage/" + pro.id)
      .then((res) => {
        setImage(res.data);
        //console.log(image);
        setX("data:" + res.data.fileType + ";base64," + res.data.data);
        //console.log(x);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  //console.log(location.state.product);

  return (
    <div className="container-fluid tm-container-content tm-mt-60">
      <div className="row mb-4">
        <h2 className="col-12 tm-text-primary">{pro.item}</h2>
      </div>
      <div id={pro.id} className="row tm-mb-90">
        <div className="col-xl-8 col-lg-7 col-md-6 col-sm-12">
          <img src={x} alt="Product" className="img-fluid" />
        </div>
        <div className="col-xl-4 col-lg-5 col-md-6 col-sm-12">
          <div className="tm-bg-gray tm-video-details">
            <h3>Description</h3>
            <h7>
              <p className="mb-4">{pro.description}</p>
            </h7>
            <div className="mb-4 d-flex flex-wrap">
              <h6>
                <div className="mr-4 mb-2">
                  <span className="tm-text-gray-dark">Price: </span>
                  <span className="tm-text-primary">{pro.price}</span>
                </div>
                <div className="mr-4 mb-2">
                  <span className="tm-text-gray-dark">Quantity </span>
                  <span className="tm-text-primary">{pro.quantity}</span>
                </div>
              </h6>
            </div>
            <div className="mb-4">
              <h3 className="tm-text-gray-dark mb-3">Brand And Year</h3>
              <h5>
                {" "}
                <p>{pro.brand}</p>
                <p>{pro.id}</p>
              </h5>
            </div>
          </div>
        </div>
      </div>
      <div>
        <h4>
          {" "}
          <a
           
            onClick={() => {
              navigate("/editProductImage", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit image
          </a>
          <a
           
            onClick={() => {
              navigate("/editProductDescription", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit Description
          </a>
          <a
           
            onClick={() => {
              navigate("/editProductPrice", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit Price
          </a>
          <a
           
            onClick={() => {
              navigate("/editProductYear", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit Year
          </a>
          <a  
          
            onClick={() => {
              navigate("/editProductQty", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit Quantity
          </a>
          <a
            onClick={() => {
              navigate("/editProductType", { state: pro });
            }}
            className="tm-text-primary mr-4 mb-2 d-inline-block"
          >
            Edit Type
          </a>
        </h4>
      </div>
      <div>
        <button
          onClick={() => {
            navigate(-1);
          }}
        >
          Return to profile
        </button>
      </div>
    </div>
  );
};
export default Detail;
