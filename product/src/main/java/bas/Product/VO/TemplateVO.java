package bas.Product.VO;

import java.util.List;

import bas.Product.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TemplateVO {
	private List<Product> products;
	private Client client;
	public List<Product> getProduct() {
		return products;
	}
	public void addProduct(Product product) {
		products.add(product);
	}
	public void removeProduct(Product p) {
		products.remove(products.indexOf(p));
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setProduct(List<Product> products) {
		this.products=products;
		
	}

}
