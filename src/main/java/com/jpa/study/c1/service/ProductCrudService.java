package com.jpa.study.c1.service;

import com.jpa.study.c1.data.ProductDto;
import com.jpa.study.c1.data.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductCrudService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name)throws Exception;

    void deleteProduct(Long number) throws Exception;
}
