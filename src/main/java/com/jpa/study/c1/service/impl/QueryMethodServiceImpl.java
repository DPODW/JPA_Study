package com.jpa.study.c1.service.impl;

import com.jpa.study.c1.data.ProductResponseDto;
import com.jpa.study.c1.entity.Product;
import com.jpa.study.c1.repo.QueryMethodRepository;
import com.jpa.study.c1.service.QueryMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QueryMethodServiceImpl implements QueryMethodService {


    private final QueryMethodRepository queryMethodRepository;


    public QueryMethodServiceImpl(QueryMethodRepository queryMethodRepository) {
        this.queryMethodRepository = queryMethodRepository;
    }

    @Override
    public ProductResponseDto getProductToName(String name) {
        Product byName = queryMethodRepository.findByName(name);

        return getProductResponseDto(byName);
    }

    @Override
    public ProductResponseDto getProductToStock(Integer stock) {
        Product byStock = queryMethodRepository.findByStock(stock);
        return getProductResponseDto(byStock);
    }

    @Override
    public Long getCountByName(String name) {
        Long countByName = queryMethodRepository.countByName(name);
        log.info("이름과 일치하는 컬럼 개수 => {}",countByName);
        return countByName;
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
