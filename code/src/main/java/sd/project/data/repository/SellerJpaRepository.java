package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Seller;

public interface SellerJpaRepository extends JpaRepository<Seller,Integer>{
	public Seller findBySellerUsername(String sellerUsername);
}
