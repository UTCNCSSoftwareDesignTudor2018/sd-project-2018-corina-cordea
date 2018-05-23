package sd.project.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.business.dto.SellerDto;
import sd.project.data.entity.Seller;
import sd.project.data.repository.SellerJpaRepository;

@Service
public class SellerService {
	@Autowired
	SellerJpaRepository sellerJpaRepository;
	public String findSeller(String user) {	
		return sellerJpaRepository.findBySellerUsername(user).getSellerPassword();
	}
	
	public void save(SellerDto sDto) {
		Seller seller = new Seller.SellerBuilder().sellerName(sDto.getSellerName()).
				sellerUsername(sDto.getSellerUsername()).
				sellerPassword(sDto.getSellerPassword()).create();
		sellerJpaRepository.save(seller);
	}
}
