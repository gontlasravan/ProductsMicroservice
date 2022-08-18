package com.learning.products.repository;

import com.learning.products.model.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {

    public Product findByProductId(int productId);

}
