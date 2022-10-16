import { React, useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, NavLink } from "react-router-dom";

const AboutProfile = ({ state }) => {
  const navigate = useNavigate();
  console.log(state);

  return (
    <div
      class="tab-pane fade show active"
      id="home"
      role="tabpanel"
      aria-labelledby="home-tab"
    >
      <div class="row">
        <div class="col-md-6">
          <label>First Name</label>{" "}
          <a
            onClick={() => {
              navigate("/editName", { state: state });
            }}
          >
            <u> Edit Name</u>
          </a>
        </div>

        <div class="col-md-6">
          <p> {state.firstName} </p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-6">
          <label>Last Name</label>{" "}
          <a
            onClick={() => {
              navigate("/editName", { state: state });
            }}
          >
            <u>Edit Name</u>
          </a>
        </div>

        <div class="col-md-6">
          <p>{state.lastName}</p>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <label>Phone</label>{" "}
          <a
            onClick={() => {
              navigate("/editPhone", { state });
            }}
          >
            <u>Edit Phone</u>
          </a>
        </div>
        <div class="col-md-6">
          <p>{state.phoneNumber}</p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-6">
          <label>Email</label>
          <a
            onClick={() => {
              navigate("/editEmail", { state });
            }}
          >
            <u>Edit Email</u>
          </a>
        </div>
        <div class="col-md-6">
          <p>{state.email}</p>
        </div>
      </div>

      <div class="row">
        <span>
          <a
            onClick={() => {
              navigate("/editPassword", { state });
            }}
          >
            <u>Edit Password</u>
          </a>
        </span>
      </div>
    </div>
  );
};
export default AboutProfile;
