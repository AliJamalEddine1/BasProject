package bas.Client.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import bas.Client.VO.TemplateVO;
import bas.Client.model.Client;
import bas.Client.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRep;
	@Autowired
	RestTemplate rest;
	public Client saveClient(Client c) {
		if(clientRep.findByEmail(c.getEmail())!=null) return null;
		else {  return clientRep.save(c);
		
		}
		
	}
	public Iterable<Client> findAllClient() {
	
		return clientRep.findAll();
	}
	//@CircuitBreaker(name="CL",fallbackMethod="myFallBack")
	//@Retry(name="CL",fallbackMethod="myFallBack")

	public String myFallBack(Throwable t) {
		return "Product is not available rigth  now";
	}
	public void deleteClient(int id) {
		 clientRep.deleteById(id);
	}
	public TemplateVO findProducts(int id) {
		TemplateVO vo=new TemplateVO();
		try {
		vo = rest.getForObject("localhost:9090/products/productsByClientId", TemplateVO.class, id);
	}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("Voila les produits");
		}
		return vo;

}
}
