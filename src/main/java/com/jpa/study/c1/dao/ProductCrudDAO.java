package com.jpa.study.c1.dao;

import com.jpa.study.c1.entity.Product;

public interface ProductCrudDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProduct(Long number,String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
