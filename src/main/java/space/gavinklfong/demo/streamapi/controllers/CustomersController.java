package space.gavinklfong.demo.streamapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.services.CustomersService;

import java.sql.Date;
import java.util.List;

@RestController
public class CustomersController {

    @Autowired
    CustomersService customersService;

    @PostMapping("Customers/create")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customersService.createCustomer(customer);
    }

    @GetMapping("Customers/retriveAll")
    public List<Customer> getAllCustomers()
    {
        return customersService.getAllCustomers();
    }

    @GetMapping("Customers/count")
    public  Long getCustomersCount()
    {
        return customersService.getCustomersCount();
    }

    @GetMapping("Customers/{id}")
    public List<Customer> getCustomersById(@PathVariable(name = "id") Long id)
    {
        return customersService.getCustomersById(id);
    }

    @GetMapping("Customers")
    public List<Customer> getCustomersByTier(@RequestParam(value = "tier") Integer tier)
    {
        return customersService.getCustomersByTier(tier);
    }

    @GetMapping("Customers/getByName")
    public List<Customer> getCustomersByStartingLetterOfName()
    {
        return customersService.getCustomersByStartingLetterOfName();
    }
    @PutMapping("Customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
    {
        return customersService.updateCustomer(customer,id);
    }

    @DeleteMapping("Customers/delete/{id}")
    public void deleteCustomer(@PathVariable Long id)
    {
        customersService.deleteCustomer(id);
    }

    @GetMapping("Customers/tier/{tier}")
    public List<Customer> getCustomerByTier(@PathVariable Integer tier)
    {
        return  customersService.findCustomerByTier(tier);
    }

    @GetMapping("Customers/Amount")
    public List<Customer> findTotalAmountOfCustomer(@RequestParam("id") Long id)
    {
        return  customersService.findTotalAmountOfCustomer(id);
    }

//    @GetMapping("Customers/Date")
//    public List<Customer> findCustomerByDate(@RequestParam("date")Date date)
//    {
//        return  customersService.findCustomerByDate(date);
//    }
}