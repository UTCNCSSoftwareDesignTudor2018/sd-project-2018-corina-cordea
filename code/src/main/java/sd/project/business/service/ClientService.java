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

	public Client findById(int id) {
		return clientJpaRepository.findByClientId(id);
	}
	
	public ClientDto findClient(String user) {
		Client client = clientJpaRepository.findByClientUsername(user);
		ClientDto cDto = new ClientDto.ClientDtoBuilder().clientId(client.getClientId())
				.clientName(client.getClientName()).clientAddress(client.getClientAddress())
				.clientCity(client.getClientCity()).clientEmail(client.getClientEmail())
				.clientPhoneNumber(client.getClientPhoneNumber()).clientPincode(client.getClientPincode())
				.clientOrders(client.getOrders()).clientUsername(client.getClientUsername())
				.clientPassword(client.getClientPassword()).create();
		return cDto;
	}

	public void save(ClientDto cDto) {
		Client client = new Client.ClientBuilder().clientName(cDto.getClientName()).clientEmail(cDto.getClientEmail())
				.clientAddress(cDto.getClientAddress()).clientCity(cDto.getClientCity())
				.clientPincode(cDto.getClientPincode()).clientPhoneNumber(cDto.getClientPhoneNumber())
				.clientUsername(cDto.getClientUsername()).clientPassword(cDto.getClientPassword()).create();
		clientJpaRepository.save(client);
	}
}
