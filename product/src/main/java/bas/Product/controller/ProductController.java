package bas.Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Product.VO.Client;
import bas.Product.VO.TemplateVO;
import bas.Product.model.Product;
import bas.Product.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
private ProductService productSer;

@PostMapping("/addnewproduct")
public Product addNewProduct(@RequestBody Product p) {
	return productSer.saveProduct(p);
}
@DeleteMapping("/deleteProduct")
public void deleteProduct(@RequestBody int id) {
	productSer.deleteProduct(id);
}
@GetMapping("/product")
public Optional<Product> getProduct(@RequestBody int id) {
	return productSer.findById(id);
}
@GetMapping("/productsByClientId")
public TemplateVO getProductsByClientId(@RequestBody int id) {
	return productSer.findByClientId(id);
}
@GetMapping("/productOwner")
public Client getProductOwner(@RequestBody int id) {
	return productSer.findProductOwner(id);
}

@GetMapping("/allproduct")
public List<Product> getProducts() {
	return productSer.getAll();
}
}
