package com.learning.products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GetResponseForProducts implements Serializable {
    private List<Product> products;
}
