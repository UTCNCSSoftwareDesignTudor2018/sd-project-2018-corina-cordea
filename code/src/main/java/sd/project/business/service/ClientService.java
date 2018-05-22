package sd.project.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.data.repository.ClientJpaRepository;

@Service
public class ClientService {
	@Autowired
	ClientJpaRepository clientJpaRepository;
	public String findClient(String user) {	
		return clientJpaRepository.findByClientUsername(user).getClientPassword();
	}
}
