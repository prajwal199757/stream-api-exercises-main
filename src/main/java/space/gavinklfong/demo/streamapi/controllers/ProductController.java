package space.gavinklfong.demo.streamapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.services.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("products/create")
     public Product createProduct(@RequestBody Product product)
    {
        return  productService.createProduct(product);
    }
}
