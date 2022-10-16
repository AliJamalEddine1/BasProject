package bas.Product.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Product.service.ProductService;

@RestController
@RequestMapping("/productUpdate")
public class ProductController {
@Autowired
private ProductService productSer;

@PostMapping("/updateId")
public boolean updateId(@RequestBody int id,@RequestBody int past) {
	return productSer.updateId(id,past);
}
@PostMapping("/updateClientID")
public boolean updateClientId(@RequestBody Integer id,@RequestBody int client) {
	return productSer.updateClientId(id,client);
}
@PostMapping("/updateType/{id}/{type}")
public boolean updateType(@PathVariable Integer id,@PathVariable String type) {
	return productSer.updateType(id,type);
}
@PostMapping("/updateQuantity/{id}/{qty}")
public boolean updateQuantity(@PathVariable Integer id,@PathVariable int qty) {
	return productSer.updateQuantity(id,qty);
}
@PostMapping("/updatePrice/{id}/{price}")
public boolean updatePrice(@PathVariable Integer id,@PathVariable double price) {
	return productSer.updatePrice(id,price);
}
@PostMapping("/updateLocation/{id}/{location}")
public boolean updateLocation(@PathVariable Integer id,@PathVariable String location) {
	return productSer.updateLocation(id,location);
}
@PostMapping("/updateImage")
public boolean updateImage(@RequestBody Integer id,@RequestBody String img) {
	return productSer.updateImage(id,img);
}
@PostMapping("/updateDescription/{id}/{desc}")
public boolean updateDescription(@PathVariable Integer id,@PathVariable String desc) {
	return productSer.updateDescription(id,desc);
}
@PostMapping("/updateYear/{id}/{year}")
public boolean updateYear(@PathVariable Integer id,@PathVariable String year) {
	return productSer.updateYear(id,year);
}
}
