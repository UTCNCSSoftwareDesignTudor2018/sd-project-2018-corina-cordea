package sd.project.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sd.project.business.dto.OrderDetailsDto;
import sd.project.business.dto.OrderDto;
import sd.project.data.entity.Client;
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
	private List<Observer> observers = new ArrayList<Observer>();
	public int save(OrderDto orderDto) {
		Order order = new Order();
		order.setClient(orderDto.getClient());
		order.setOrderDate(orderDto.getOrderDate());
		order.setOrderPaymentMethod(orderDto.getOrderPaymentMethod());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setOrderTotalPrice(orderDto.getOrderTotalPrice());
		return orderJpaRepository.save(order).getOrderId();
	}
	public void updateOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setClient(orderDto.getClient());
		order.setOrderDate(orderDto.getOrderDate());
		order.setOrderPaymentMethod(orderDto.getOrderPaymentMethod());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setOrderTotalPrice(orderDto.getOrderTotalPrice());
		orderJpaRepository.save(order);
		notifyAllObservers();
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
	public List<OrderDto> findOrdersByClient(Client client){
		List<Order> orders = orderJpaRepository.findByClient(client);
		List<OrderDto> ordersDto = new ArrayList<>();
		for(Order order: orders) {
			OrderDto oDto = getOrderDto(order);
			ordersDto.add(oDto);
		}
		return ordersDto;
	}
	public List<OrderDto> findOrders(){
		List<Order> orders = orderJpaRepository.findAll();
		List<OrderDto> ordersDto = new ArrayList<>();
		for(Order order: orders) {
			OrderDto oDto = getOrderDto(order);
			ordersDto.add(oDto);
		}
		return ordersDto;
	}
	public OrderDto getOrderDto(Order order) {
		OrderDto oDto = new OrderDto();
		oDto.setOrderId(order.getOrderId());
		oDto.setClient(order.getClient());
		oDto.setOrderDate(order.getOrderDate());
		oDto.setOrderPaymentMethod(order.getOrderPaymentMethod());
		oDto.setOrderStatus(order.getOrderStatus());
		oDto.setOrderTotalPrice(order.getOrderTotalPrice());
		oDto.setProducts(order.getProducts());
		return oDto;
	}
	 public void attach(Observer observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(){
	      for (Observer observer : observers) {
	         observer.update(null, observer);
	      }
	   } 	
}
