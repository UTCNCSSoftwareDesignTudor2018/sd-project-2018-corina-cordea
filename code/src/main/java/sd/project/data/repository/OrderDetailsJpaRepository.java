package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.OrderDetails;

public interface OrderDetailsJpaRepository  extends JpaRepository<OrderDetails,Integer>{

}
