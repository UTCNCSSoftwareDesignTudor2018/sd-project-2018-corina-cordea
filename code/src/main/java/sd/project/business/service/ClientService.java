package sd.project.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.business.dto.ClientDto;
import sd.project.data.entity.Client;
import sd.project.data.repository.ClientJpaRepository;

@Service
public class ClientService {
	@Autowired
	ClientJpaRepository clientJpaRepository;
	public String findClient(String user) {	
		return clientJpaRepository.findByClientUsername(user).getClientPassword();
	}
	
	public void save(ClientDto cDto) {
		Client client = new Client.ClientBuilder().clientName(cDto.getClientName()).
				clientEmail(cDto.getClientEmail()).
				clientAddress(cDto.getClientAddress()).
				clientCity(cDto.getClientCity()).
				clientPincode(cDto.getClientPincode()).
				clientPhoneNumber(cDto.getClientPhoneNumber()).
				clientUsername(cDto.getClientUsername()).
				clientPassword(cDto.getClientPassword()).create();
		clientJpaRepository.save(client);
	}
}
