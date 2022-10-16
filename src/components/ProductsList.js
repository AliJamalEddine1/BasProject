import React, { Component } from "react";
import Products from "./Products";

class ProductsList extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="row tm-mb-90 tm-gallery">
        <Products />
      </div>
    );
  }
}

export default ProductsList;
