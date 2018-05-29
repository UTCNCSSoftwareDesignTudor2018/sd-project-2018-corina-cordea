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

	public Seller findById(int id) {
		return sellerJpaRepository.findBySellerId(id);
	}
	
	public SellerDto findSeller(String user) {
		Seller seller = sellerJpaRepository.findBySellerUsername(user);
		SellerDto sDto = new SellerDto.SellerDtoBuilder().sellerId(seller.getSellerId())
				.sellerName(seller.getSellerName()).sellerProducts(seller.getProducts())
				.sellerUsername(seller.getSellerUsername()).sellerPassword(seller.getSellerPassword()).create();
		return sDto;
	}

	public void save(SellerDto sDto) {
		Seller seller = new Seller.SellerBuilder().sellerName(sDto.getSellerName())
				.sellerUsername(sDto.getSellerUsername()).sellerPassword(sDto.getSellerPassword()).create();
		sellerJpaRepository.save(seller);
	}
}
