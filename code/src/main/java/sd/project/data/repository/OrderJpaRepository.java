package sd.project.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Client;
import sd.project.data.entity.Order;

public interface OrderJpaRepository extends JpaRepository<Order,Integer> {
	public Order findByOrderId(int id);
	public List<Order> findByClient(Client client);
}
