package pl.com.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.productservice.model.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
