import React, { useState, useEffect } from "react";
import { NavLink } from "react-router-dom";
import { axiosPublic } from "../common/axiosPublic";
import PaginationMethod from "./PaginationMethod";
const Products = () => {
  const [products, setProducts] = useState([]);
  const [pro, setPro] = useState([]);
  const [data, setData] = useState([]);
  useEffect(() => {
    fetchProducts();
  }, []);
  const [loading, setLoading] = useState(true);
  const fetchProducts = async () => {
    await axiosPublic
      .get("products/allproduct")
      .then((res) => {
        console.log(res);
        setLoading(false);
        setProducts(res.data);
      })
      .catch((err) => {
        console.log(err);
        console.log("erroedcmvc");
      });
    await axiosPublic
      .get("image/getAll")
      .then((res) => {
        console.log(res);
        setLoading(false);
        setData(res.data);
      })
      .catch((err) => {
        console.log(err);
        console.log("erroedcmvc");
      });

    console.log(products);
  };

  const [currentPage, setCurrentPage] = useState(1);
  const [recordsPerPage] = useState(8);
  const [proDisp, setProDisp] = useState(1);
  const indexOfLastRecord = currentPage * recordsPerPage;
  const indexOfFirstRecord = indexOfLastRecord - recordsPerPage;
  const currentRecords = data.slice(indexOfFirstRecord, indexOfLastRecord);
  const nPages = Math.ceil(data.length / recordsPerPage);
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
                data.find((d) => d.productId == product.id)?.fileType
              };base64,
              ${data.find((d) => d.productId == product.id)?.data}`}
              alt="Imag"
              className="img-fluid"
            />

            <figcaption className="d-flex align-items-center justify-content-center">
              <h2>{product.type}</h2>
              <NavLink to="/detailsPublic" state={{ product }}>
                <a href="#">View more</a>
              </NavLink>
            </figcaption>
          </figure>
          <div className="d-flex justify-content-between tm-text-gray">
            <span className="tm-text-gray-light">{product.price}$</span>
            <span>{product.quantity}</span>
          </div>
        </div>
      ))}

      <PaginationMethod
        nPages={nPages}
        currentPage={currentPage}
        setCurrentPage={setCurrentPage}
      />
    </div>
  );
};
export default Products;
