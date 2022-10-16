package bas.Client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Client.model.Client;
import bas.Client.service.ClientService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/searchClients")
public class ClientController {
@Autowired
private ClientService clientSer;

@PostMapping("/searchId")
public Client searchId(@RequestBody int id) {
	return clientSer.searchId(id);
}

@PostMapping("/searchFirstName")
public List<Client> searchFirstName(@RequestBody String fname) {
	return clientSer.searchFirstName(fname);
}
@PostMapping("/searchLastName")
public List<Client> searchLastName(@RequestBody String lname) {
	return clientSer.searchLastName(lname);
}
@PostMapping("/login/{email}/{pass}")
public List<Client> searchEmail(@PathVariable String email,@PathVariable String pass) {
	return clientSer.searchEmail(email,pass);
}
@PostMapping("/searchEmail/{email}")
public List<Client> searchEmail(@PathVariable String email) {
	return clientSer.searchEmail(email);
}
@PostMapping("/searchGender")
public List<Client> searchGender(@RequestBody String gender) {
	return clientSer.searchGender(gender);
}
@PostMapping("/searchPhoneNumber/{id}")
public Integer searchPhoneNumber(@PathVariable int id) {
	return clientSer.searchPhoneNumber(id);
}

}