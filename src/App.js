import "./css/bootstrap.min.css";
import "./fontawesome/css/all.min.css";
import "./css/templatemo-style.css";
import React, { useState } from "react";
import ProductsList from "./components/ProductsList";
import { Routes, Route, Switch, BrowserRouter, Link } from "react-router-dom";
import Navigation from "./pages/navigation";
import Home from "./pages/home";
import About from "./pages/about";
import LoginForm from "./pages/loginForm";
import RegisterForm from "./pages/registerForm";
import Profile from "./pages/profile";
import Detail from "./pages/detail";
import ProductDetails from "./pages/productDetails";
import AddNewProduct from "./pages/addNewProduct";
import Search from "./pages/search";
import DetailsPublic from "./pages/detailsPublic";
//import ProductDetails from "./pages/productDetails";
import EditName from "./pages/edit";
import EditPassword from "./pages/editPassword";
import EditPhone from "./pages/editPhone";
import EditProductType from "./pages/product/editProductType";
import EditProductYear from "./pages/product/editProductYear";
import EditProductDescription from "./pages/product/editProductDescription";
import EditProductLocation from "./pages/product/editProductLocation";
import EditProductImage from "./pages/product/editProductImage";
import EditProductPrice from "./pages/product/editProductPrice";
import EditProductQty from "./pages/product/editProductQty";
//import ErrorBoundary from "./pages/errorB
import EditEmail from "./pages/editEmail";
import axios from "axios";
import AuthService from "./components/jwt";

function App() {
  return (
    <div>
      <div>
        <div className="loader-section section-left"></div>
        <div className="loader-section section-right"></div>
      </div>
      <nav className="navbar navbar-expand-lg  tm-bg-gray">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            <i className="fas mr-2"></i>
            --- BAS --- <br />
            Buy And Sell
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i className="fas fa-bars"></i>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <div className="navbar-nav ml-auto mb-2 mb-lg-0">
              <Navigation />
            </div>
          </div>
        </div>
      </nav>
      <div>
        <Routes>
          <Route path="/" element={<Home />}>
            {" "}
            Home{" "}
          </Route>
          <Route path="/login" element={<LoginForm />}>
            {" "}
            Sell{" "}
          </Route>
          <Route path="/about" element={<About />}>
            {" "}
            About{" "}
          </Route>
          <Route path="/contact" element={<LoginForm />}>
            {" "}
            Contact{" "}
          </Route>
          <Route path="/registerForm" element={<RegisterForm />}>
            {" "}
            register{" "}
          </Route>
          <Route path="/profile" element={<Profile />}>
            {" "}
            profile{" "}
          </Route>

          <Route path="/detail" element={<Detail />}>
            {" "}
            profile{" "}
          </Route>
          <Route path="/details" element={<ProductDetails />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editName" element={<EditName />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editEmail" element={<EditEmail />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editPhone" element={<EditPhone />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editPassword" element={<EditPassword />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductType" element={<EditProductType />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductYear" element={<EditProductYear />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductLocation" element={<EditProductLocation />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductImage" element={<EditProductImage />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductPrice" element={<EditProductPrice />}>
            {" "}
            details{" "}
          </Route>
          <Route
            path="/editProductDescription"
            element={<EditProductDescription />}
          >
            {" "}
            details{" "}
          </Route>
          <Route path="/editProductQty" element={<EditProductQty />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/search" element={<Search />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/detailsPublic" element={<DetailsPublic />}>
            {" "}
            details{" "}
          </Route>
          <Route path="/productDetails" element={<ProductDetails />}>
            {" "}
            details{" "}
          </Route>
        </Routes>
      </div>
      <footer className="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
        <div className="container-fluid tm-container-small">
          <div className="row">
            <div className="col-lg-6 col-md-12 col-12 px-5 mb-5">
              <h3 className="tm-text-primary mb-4 tm-footer-title">
                About BAS
              </h3>
              <p>
                BAS is free{" "}
                <a rel="sponsored" href="https://v5.getbootstrap.com/">
                  Contact
                </a>{" "}
                .......................................................
                ........................................................................................................
              </p>
            </div>
            <div className="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
              <h3 className="tm-text-primary mb-4 tm-footer-title">
                Our Links
              </h3>
              <ul className="tm-footer-links pl-0">
                <li>
                  <a href="#">Advertise</a>
                </li>
                <li>
                  <a href="#">Support</a>
                </li>
                <li>
                  <a href="#">Our Company</a>
                </li>
                <li>
                  <a href="#">Contact</a>
                </li>
              </ul>
            </div>
            <div className="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
              <ul className="tm-social-links d-flex justify-content-end pl-0 mb-5">
                <li className="mb-2">
                  <a href="https://facebook.com">
                    <i className="fab fa-facebook"></i>
                  </a>
                </li>
                <li className="mb-2">
                  <a href="https://twitter.com">
                    <i className="fab fa-twitter"></i>
                  </a>
                </li>
                <li className="mb-2">
                  <a href="https://instagram.com">
                    <i className="fab fa-instagram"></i>
                  </a>
                </li>
                <li className="mb-2">
                  <a href="https://pinterest.com">
                    <i className="fab fa-pinterest"></i>
                  </a>
                </li>
              </ul>
              <a href="#" className="tm-text-gray text-right d-block mb-2">
                Terms of Use
              </a>
              <a href="#" className="tm-text-gray text-right d-block">
                Privacy Policy
              </a>
            </div>
          </div>
          <div className="row">
            <div className="col-lg-8 col-md-7 col-12 px-5 mb-3">
              Copyright 2022 BAS Company. All rights reserved.
            </div>
            <div className="col-lg-4 col-md-5 col-12 px-5 text-right">
              Designed by{" "}
              <a
                href="https://templatemo.com"
                className="tm-text-gray"
                rel="sponsored"
                target="_parent"
              >
                AJD
              </a>
            </div>
          </div>
        </div>
      </footer>
    </div>
  );
}

export default App;
