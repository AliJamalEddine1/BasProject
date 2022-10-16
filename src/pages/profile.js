import { React, useState, useEffect } from "react";
import "../css/profile.css";
import axios from "axios";
import {
  NavLink,
  Routes,
  Route,
  useLocation,
  useNavigate,
} from "react-router-dom";
import MyProducts from "./myproducts";
import AboutProfile from "./aboutProfile";
import AddNewProduct from "./addNewProduct";
import ProductsList from "../components/ProductsList";
import AuthService from "../components/jwt";

const Profile = () => {
  const [pagination, setPagination] = useState(true);
  const  state  = JSON.parse(localStorage.getItem("user"));
  console.log(state);
  //const { state } = useLocation();
  const navigate = useNavigate();
  const [myPage, setMyPage] = useState(<AboutProfile state={state} />);
  //
  const handleProfile1 = () => {
    setMyPage(<AboutProfile state={state} />);
  };
  const handleProfile2 = () => {
    console.log(state.id);
    setMyPage(<MyProducts id={state.id} />);
  };
  const handleNewProduct = () => {
    console.log(state.id);
    setMyPage(<AddNewProduct id={state.id} />);
  };
  return (
    <div className="back">
      <div class="container emp-profile">
        <div class="row">
          <div class="col-md-6">
            <div class="profile-head">
              <h5>
                {state.firstName} {state.lastName}
              </h5>
              <h6>Welcome to our company</h6>
              <p class="proile-rating">
                RANKINGS : <span>{state.id}</span>
              </p>
              <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                  <a
                    className="nav-link active"
                    id="home-tab"
                    data-toggle="tab"
                    role="tab"
                    aria-controls="home"
                    aria-selected="true"
                    onClick={() => {
                      handleProfile1();
                    }}
                  >
                    About
                  </a>
                </li>
                <li class="nav-item">
                  <a
                    className="nav-link"
                    aria-selected="true"
                    onClick={() => {
                      handleProfile2();
                    }}
                  >
                    Your Products
                  </a>
                </li>
                <li class="nav-item">
                  <a
                    className="nav-link"
                    aria-selected="true"
                    onClick={() => {
                      handleNewProduct();
                    }}
                  >
                    Sell new product
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-2">
            <input
              type="submit"
              class="profile-edit-btn"
              name="btnAddMore"
              onClick={() => {
                AuthService.logout();
                navigate("/login");
              }}
              value="Logout"
            />
          </div>
          <div class="col-md-8 tab-content profile-tab">{myPage}</div>
        </div>
      </div>
    </div>
  );
};
export default Profile;
