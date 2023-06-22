package cloud1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cloud1.model.Product;



public interface ProductRepository extends MongoRepository<Product, String> {

}
