package bas.Product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import bas.Product.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	List<Product> findAll();
	List<Product> findByClientId(int id);

}
