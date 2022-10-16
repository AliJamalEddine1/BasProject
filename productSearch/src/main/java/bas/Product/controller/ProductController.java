package bas.Product.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Product.model.Product;
import bas.Product.service.ProductService;

@RestController
@RequestMapping("/searchProducts")
public class ProductController {
@Autowired
private ProductService productSer;

@GetMapping("/searchId/{id}")
public Product searchId(@PathVariable int id) {
	return productSer.searchId(id);
}
@GetMapping("/searchClientID/{client}")
public List<Product> searchClientId(@PathVariable int client) {
	return productSer.searchClientId(client);
}
@GetMapping("/searchType/{type}")
public List<Product> searchType(@PathVariable String type) {
	return productSer.searchType(type);
}
@GetMapping("/searchQuantity")
public List<Product> searchQuantity(@RequestBody int qty) {
	return productSer.searchQuantity(qty);
}
@GetMapping("/searchPrice")
public List<Product> searchPrice(@RequestBody double price1,@RequestBody double price2) {
	return productSer.searchPrice(price1,price2);
}
@GetMapping("/searchLocation/loc")
public List<Product> searchLocation(@PathVariable String loc) {
	return productSer.searchLocation(loc);
}

@GetMapping("/searchDescription")
public List<Product> searchDescription(@PathVariable String desc) {
	return productSer.searchDescription(desc);
}
@GetMapping("/search/{s}")
public List<Product> search(@PathVariable String s) {
	return productSer.search(s);
}
}
