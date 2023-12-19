package com.jpa.study.c1.service.impl;

import com.jpa.study.c1.dao.ProductCrudDAO;
import com.jpa.study.c1.data.ProductDto;
import com.jpa.study.c1.data.ProductResponseDto;
import com.jpa.study.c1.entity.Product;
import com.jpa.study.c1.service.ProductCrudService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductCrudDAO productCrudDAO;

    public ProductCrudServiceImpl(ProductCrudDAO productCrudDAO) {
        this.productCrudDAO = productCrudDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productCrudDAO.selectProduct(number);

        return getProductResponseDto(product);
    }


    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdateAt(LocalDateTime.now());

        Product saveProduct = productCrudDAO.insertProduct(product);

        return getProductResponseDto(saveProduct);
        // 저장 타입은 void  /  boolean 으로 하는 경우가 많다. (현재는 공부 용도라 리턴 받아서 결과를 봐야함)
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product changeProduct = productCrudDAO.updateProduct(number, name);

        //빈 생성자
        return getProductResponseDto(changeProduct);
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productCrudDAO.deleteProduct(number);
    }

    private static ProductResponseDto getProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());
        return productResponseDto;
    }
}
