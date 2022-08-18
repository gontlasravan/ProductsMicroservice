package com.learning.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products_tbl")
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = -4439114469417994311L;
    private int productId;
    private String productName;
    private double amount;
}
