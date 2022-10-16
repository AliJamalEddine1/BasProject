package bas.Client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bas.Client.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

	Client findById(int id);

	Client findByEmail(String email);


}
