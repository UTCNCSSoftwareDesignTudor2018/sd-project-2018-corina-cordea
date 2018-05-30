package sd.project.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.business.dto.OrderDetailsDto;
import sd.project.business.dto.OrderDto;
import sd.project.data.entity.Order;
import sd.project.data.entity.OrderDetails;
import sd.project.data.repository.OrderDetailsJpaRepository;
import sd.project.data.repository.OrderJpaRepository;

@Service
public class OrderService {
	@Autowired
	OrderJpaRepository orderJpaRepository;
	@Autowired
	OrderDetailsJpaRepository orderDetailsJpaRepository;
	public int save(OrderDto orderDto) {
		Order order = new Order();
		order.setClient(orderDto.getClient());
		order.setOrderDate(orderDto.getOrderDate());
		order.setOrderPaymentMethod(orderDto.getOrderPaymentMethod());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setOrderTotalPrice(orderDto.getOrderTotalPrice());
		return orderJpaRepository.save(order).getOrderId();
	}
	public int saveOrderDetails(OrderDetailsDto orderDto) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrder(orderDto.getOrder());
		orderDetails.setProduct(orderDto.getProduct());
		orderDetails.setQuantity(orderDto.getQuantity());
		return orderDetailsJpaRepository.save(orderDetails).getOrderDetailsId();
	}
	public Order findById(int id) {
		return orderJpaRepository.findByOrderId(id);
	}
}
