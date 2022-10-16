package bas.Client.VO;

import java.util.List;

import bas.Client.model.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class TemplateVO {
private List<Product> product;
private Client client;
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}

}
