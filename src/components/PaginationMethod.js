import React, { useState, useEffect } from "react";
import axios from "axios";
const PaginationMethod = ({ nPages, currentPage, setCurrentPage }) => {
  const pageNumbers = [...Array(nPages + 1).keys()].slice(1);
  const nextPage = () => {
    if (currentPage !== nPages) setCurrentPage(currentPage + 1);
  };
  const prevPage = () => {
    if (currentPage !== 1) setCurrentPage(currentPage - 1);
  };
  return (
    <div className="col-12 d-flex justify-content-between align-items-center tm-paging-col">
      <a
        href="#"
        onClick={prevPage}
        className=" btn-primary tm-btn-prev mb-2 disabled"
      >
        Previous
      </a>

      {pageNumbers.map((pgNo) => {
        return (
          <div className="tm-paging d-flex">
            <a
              href="#"
              className="{tm-paging-link ${currentPage==pgNo?'active':''}"
              key="{pgNo}"
              onClick={() => setCurrentPage(pgNo)}
            >
              {" "}
              {pgNo}{" "}
            </a>
          </div>
        );
      })}

      <a href="#" className=" btn-primary tm-btn-next" onClick={nextPage}>
        Next Page
      </a>
    </div>
  );
};
export default PaginationMethod;
