package space.gavinklfong.demo.streamapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.services.OrderService;

import java.sql.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("orders/create")
    public Order createOrder(@RequestBody Order order)
    {
        return orderService.createOrder(order);
    }

    @DeleteMapping("orders/delete/{id}")
    public void deleteOrder(@PathVariable Long id)
    {
        orderService.deleteOrder(id);
    }

//    @GetMapping("Customers/Date")
//    public List<Customer> findCustomerByDate(@RequestParam("date") Date date)
//    {
//        return  orderService.findByDate(date);
//    }
}
