package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Order;

public interface OrderJpaRepository extends JpaRepository<Order,Integer> {

}
