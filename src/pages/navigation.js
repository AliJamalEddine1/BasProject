import React from "react";
import { NavLink } from "react-router-dom";

const Navigation = () => {
  return (
    <ul className="navbar-nav ml-auto mb-2 mb-lg-0">
      <li className="nav-item">
        <NavLink to="/" className="nav-link nav-link-1 ">
          {" "}
          Home
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink to="/login" className="nav-link nav-link-2 ">
          Sell
        </NavLink>
      </li>
      
      <li className="nav-item">
        <NavLink to="/login" className="nav-link nav-link-4 ">
          Login
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink to="/registerForm" className="nav-link nav-link-4 ">
         SignUp
        </NavLink>
      </li>
      <li className="nav-item">
        <NavLink to="/about" className="nav-link nav-link-3 ">
          About
        </NavLink>
      </li>
    </ul>
  );
};
export default Navigation;
