package space.gavinklfong.demo.streamapi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.gavinklfong.demo.streamapi.exceptions.RecordNotFoundException;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(Long id) {
        if (orderRepo.existsById(id))
        {
            orderRepo.deleteById(id);
        }
        else
        {
            throw new RecordNotFoundException();
        }
    }
//    public List<Customer> findByDate(Date date)
//    {
//        List<Order> result = orderRepo.findCustomerByOrderDate(date);
//        List<Customer> resultSet=new ArrayList<>();
//        for (Order re:
//        result) {
//            resultSet.add(re.getCustomer());
//        }
//
//        return resultSet;
//    }
}
