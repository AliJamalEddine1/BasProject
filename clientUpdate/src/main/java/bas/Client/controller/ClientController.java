package bas.Client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bas.Client.model.Client;
import bas.Client.service.ClientService;



@RestController
@RequestMapping("/updateClients")
public class ClientController {
@Autowired
private ClientService clientSer;

@PostMapping("/updateId")
public boolean updateId(@RequestBody int id,@RequestBody int past) {
	return clientSer.updateId(id,past);
}

@PostMapping("/updateFirstName")
public boolean updateFirstName(@RequestBody Integer id,@RequestBody String fname) {
	return clientSer.updateFirstName(id,fname);
}
@PostMapping("/updateName/{id}/{fname}/{lname}")
public boolean updateName(@PathVariable Integer id,@PathVariable String fname,@PathVariable String lname) {
	return clientSer.updateName(id,fname,lname);
}
@PostMapping("/updatePassword/{id}/{oldpass}/{newpass}")
public boolean updatePassword(@PathVariable Integer id,@PathVariable String oldpass,@PathVariable String newpass) {
	return clientSer.updatePassword(id,oldpass,newpass);
}
@PostMapping("/updateEmail/{id}/{email}/{newEmail}")
public Client updateEmail(@PathVariable int id,@PathVariable String email,@PathVariable String newEmail) {
	return clientSer.updateEmail(id,email,newEmail);
}
@PostMapping("/updateGender/{id}/{gender}")
public boolean updateLocation(@PathVariable Integer id,@PathVariable String gender) {
	return clientSer.updateGender(id,gender);
}
@PostMapping("/updatePhoneNumber/{id}/{phone}")
public boolean updatePhoneNumber(@PathVariable Integer id,@PathVariable String phone) {
	return clientSer.updatePhoneNumber(id,phone);
}

}