package com.learning.products.controller;

import com.learning.products.model.GetResponseForProducts;
import com.learning.products.model.Product;
import com.learning.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @Value("${spring.data.mongodb.database}")
    private String temp;

    @GetMapping(path = "/getAllProducts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)

    public GetResponseForProducts getAllProducts(){
        return productService.retrieveAllProducts();
    }

    @GetMapping(path = "/getProduct/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("productId") int productId){
        return productService.retrieveProduct(productId);
    }

    @PostMapping(path = "/postAllProducts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postAllProducts(@RequestBody List<Product> products){

        return productService.addProducts(products);
    }

    @GetMapping(path = "/getConfigProperty")
    public String getConfigProperty(){


        System.out.println("Property: "+temp);
        return temp;
    }


}
