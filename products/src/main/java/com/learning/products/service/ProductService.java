package com.learning.products.service;

import com.learning.products.model.GetResponseForProducts;
import com.learning.products.model.Product;
import com.learning.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Cacheable(value = "Product")
    public GetResponseForProducts retrieveAllProducts(){

        List<Product>  productList = productRepository.findAll();
        GetResponseForProducts resp = new GetResponseForProducts();
        resp.setProducts(productList);

        return resp;
    }
    @Cacheable(value = "Product",key = "#productId")
    public Product retrieveProduct(int productId){

        System.out.println("Searching in MongoDb :"+productId);
        Product product = new Product();
        product =productRepository.findByProductId(productId);
        System.out.println("Output :"+productRepository.findByProductId(productId));

    return product;
    }

    public String addProducts(List<Product> products){

        return productRepository.saveAll(products).toString();

    }

}
