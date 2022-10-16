package bas.Client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Client.VO.TemplateVO;
import bas.Client.model.Client;
import bas.Client.service.ClientService;


@CrossOrigin(origins = "http://localhost:9191")
@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	private ClientService clientSer;
	
	@PostMapping("/clientRegister")
	public Client registerClient(@RequestBody Client c) {
	return clientSer.saveClient(c);
	}
	
	@GetMapping("/clientInfo")
	public Iterable<Client> getAllClient() {
		 return clientSer.findAllClient();
	}
	@DeleteMapping("/clientid")
	public void deleteClient(@RequestBody int id){
		 
		clientSer.deleteClient(id);
	}
	@GetMapping("/productOfClient")
	public TemplateVO getProductOfClient(@RequestBody int id){
		return clientSer.findProducts(id);
	}
	
}
