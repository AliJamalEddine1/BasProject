import React from "react";
import { BrowserRouter, Route, Routes, Link, Navigate } from "react-router-dom";
import Navigation from "./navigation";
import ProductsList from "../components/ProductsList";
import About from "./about";
import Background from "../img/hero.jpg";
class Home extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    function handleSubmit(e) {
      const x = document.getElementById("1").value;
      e.preventDefault();

      if (x) {
        <Navigate to="/search" state={{ x }} />;
      }
    }
    return (
      <div class="container-fluid tm-container-content tm-mt-60">
        <div
          className="tm-hero d-flex justify-content-center align-items-center "
          data-parallax="scroll"
        >
          <form
            className="d-flex tm-search-form"
            onSubmit={(e) => handleSubmit(e)}
          >
            <input
              className="form-control  "
              id="1"
              type="search"
              placeholder="Search"
              aria-label="Search"
            />

            <button
              className="btn btn-outline-success tm-search-btn"
              type="submit"
            >
              <i className="fas fa-search"></i>
            </button>
          </form>
        </div>
        <div
          className="container-fluid tm-container-content tm-mt-60 "
          id="flex"
        >
          <div id="del">
            <div className="row mb-4  tm-bg-gray">
              <h2 className="col-6 tm-text-primary">Latest product</h2>
            </div>
            <div className="tm-text-primary row mb-4"></div>
            <ProductsList />
          </div>
        </div>
      </div>
    );
  }
}
export default Home;
