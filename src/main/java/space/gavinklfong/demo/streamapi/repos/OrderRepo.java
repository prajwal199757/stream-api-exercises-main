package space.gavinklfong.demo.streamapi.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RequestParam;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

	List<Order> findAll();

//	@Query(value = "select customer.\"name\"\n" +
//			"from customer INNER join product_order\n" +
//			"on customer.id = product_order.customer_id\n" +
//			"where product_order.order_date=:orderdate",nativeQuery = true)
//	List<Order> findCustomerByOrderDate(@RequestParam("orderdate") Date orderdate);
}
