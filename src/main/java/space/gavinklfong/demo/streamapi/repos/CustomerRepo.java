package space.gavinklfong.demo.streamapi.repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.web.bind.annotation.RequestParam;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {

	List<Customer> findAll();
	boolean existsByTier(Integer tier);
	@Query(value = "select * from Customers where Customers.name like 's%'",nativeQuery = true)
	List<Customer> findByLetterOfName();

	@Query(value = "select * from customer where tier= :tier ",nativeQuery = true)
	List<Customer> findCustomerByTier( Integer tier);

	@Query(value = "select * from customer\n" +
			"INNER join product_order\n" +
			"on customer.id = product_order.customer_id\n" +
			"where customer.id=:id",nativeQuery = true)
	List<Customer> findTotalAmount(Long id);


}
