package space.gavinklfong.demo.streamapi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.gavinklfong.demo.streamapi.exceptions.RecordNotFoundException;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CustomersService {

    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        Customer result = customerRepo.save(customer);
        log.info("Customers details saved");
        return result;
    }

    public List<Customer> getAllCustomers() {
       List<Customer> result=customerRepo.findAll();
       return result;
    }

    public Long getCustomersCount() {
        long result = customerRepo.count();
        return result;
    }

    public List<Customer> getCustomersById(Long id)  {
        List<Customer> result=new ArrayList<>();
        if (customerRepo.existsById(id)) {
            result = customerRepo.findAll().stream().filter(e -> e.getId().equals(id)).collect(Collectors.toList());
        }
        else
        {
            throw new RecordNotFoundException();
        }
        return result;
    }


    public List<Customer> getCustomersByTier(Integer tier) {
        List<Customer> result=new ArrayList<>();
        if (customerRepo.existsByTier(tier))
        {
            result = customerRepo.findAll().stream().filter(e -> e.getTier().equals(tier)).collect(Collectors.toList());

        }
        else
        {
            throw new RecordNotFoundException();
        }
        return result;
    }

    public List<Customer> getCustomersByStartingLetterOfName() {
        List<Customer> result = customerRepo.findByLetterOfName();
        return result;
    }

    public Customer updateCustomer(Customer customer, Long id) {
        Customer newCustomer = customer;
        if (customerRepo.existsById(id))
        {
            customerRepo.save(newCustomer);
        }
        else
        {
            throw new RecordNotFoundException();
        }
        return newCustomer;
    }

    public void deleteCustomer(Long id) {

        if (customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else
        {
            throw new RecordNotFoundException();
        }

    }

    public List<Customer> findCustomerByTier(Integer tier) {

        List<Customer> result = customerRepo.findCustomerByTier(tier);
        return result;


    }

    public List<Customer> findTotalAmountOfCustomer(Long id)
    {
        List<Customer> result = customerRepo.findTotalAmount(id);
        return result;
    }

//    public List<Customer> findCustomerByDate(Date date)
//    {
//        List<Customer> result = customerRepo.findCustomerByOrderDate(date);
//        return result;
//    }
}

