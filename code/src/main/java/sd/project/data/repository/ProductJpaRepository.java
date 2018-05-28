package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Product;

public interface ProductJpaRepository extends JpaRepository<Product,Integer>{
	public Product findByProductImage(String image);
}
