package bas.Product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bas.Product.VO.Client;
import bas.Product.VO.TemplateVO;
import bas.Product.model.Product;
import bas.Product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private RestTemplate rest;

	public Product saveProduct(Product p) {
		return productRep.save(p);
	}

	public List<Product> getProducts(int id) {
		
		return productRep.findAll();
	}
	
	public TemplateVO findByClientId(int id) {
		
		TemplateVO temp = new TemplateVO();
		try {
		List<Product>  products = productRep.findByClientId(id);
			Client c = rest.getForObject("localhost:9094/searchClients/searchId", Client.class, id);
			temp.setProduct(products);
			temp.setClient(c);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Null product okk");
		}
		finally {
			System.out.println("Exit");
		}
		return temp;
	}

	public List<Product> getAll() {
		return productRep.findAll();
	}

	public Optional<Product> findById(int id) {
		
		return productRep.findById(id);
	}

	public Client findProductOwner(int id) {
		Client c=new Client();
		try {
			c = rest.getForObject("localhost:9094/searchClients/searchId", Client.class, id);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Mon exception");
		}
		finally {
			System.out.println("Exit");
		}
		return c;
	}

	public void deleteProduct(int id) {
		
		productRep.deleteById(id);
		
	}

}
