package sd.project.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.project.data.repository.SellerJpaRepository;

@Service
public class SellerService {
	@Autowired
	SellerJpaRepository sellerJpaRepository;
	public String findSeller(String user) {	
		return sellerJpaRepository.findBySellerUsername(user).getSellerPassword();
	}
}
