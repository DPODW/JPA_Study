package com.jpa.study.c1.service;

import com.jpa.study.c1.data.ProductResponseDto;
import com.jpa.study.c1.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueryMethodService {
    ProductResponseDto getProductToName(String name);

    ProductResponseDto getProductToStock(Integer stock);

    Long getCountByName(String name);

    boolean isProductExist(Long number);

    List<Product>getTop2ProductByName(String name);

    List<Product>getProductNotToName(String name);

    List<Product>getLessThanPrice(Integer price);


}
