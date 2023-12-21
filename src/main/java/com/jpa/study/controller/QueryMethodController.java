package com.jpa.study.controller;

import com.jpa.study.c1.data.ProductResponseDto;
import com.jpa.study.c1.entity.Product;
import com.jpa.study.c1.service.QueryMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/queryMethod")
public class QueryMethodController {

    private final QueryMethodService queryMethodService;

    public QueryMethodController(QueryMethodService queryMethodService) {
        this.queryMethodService = queryMethodService;
    }

    @GetMapping("/ToName/{name}")
    public ResponseEntity<ProductResponseDto> getProductToName(@PathVariable String name){
        ProductResponseDto productToName = queryMethodService.getProductToName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productToName);
    }

    @GetMapping("/ToStock/{stock}")
    public ResponseEntity<ProductResponseDto> getProductToStock(@PathVariable Integer stock){
        ProductResponseDto productToStock = queryMethodService.getProductToStock(stock);
        return ResponseEntity.status(HttpStatus.OK).body(productToStock);
    }

    @GetMapping("/CountByName/{name}")
    public ResponseEntity<Long> getCountByName(@PathVariable String name){
        Long countByName = queryMethodService.getCountByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(countByName);
    }

    @GetMapping("/ProductExist/{number}")
    public boolean isProductExist(@PathVariable Long number){
        boolean productExist = queryMethodService.isProductExist(number);
        log.info("Product 에 데이터가 존재할까? => {}",productExist);
        return productExist;
    }


    @GetMapping("/Top2ProductByName/{name}")
    public  ResponseEntity<List<Product>> getTop2ProductByName(@PathVariable String name){
        List<Product> top2ByName = queryMethodService.getTop2ProductByName(name);
        log.info("상위에 저장된 2개의 Product 를 가져옵니다.=> {}",top2ByName);
        return ResponseEntity.status(HttpStatus.OK).body(top2ByName);
    }

    @GetMapping("/ProductNotToName/{name}")
    public  ResponseEntity<List<Product>> getProductNotToName(@PathVariable String name){
        List<Product> notToName = queryMethodService.getProductNotToName(name);
        log.info("요청 이름이 포함되지 않는 Product => {}",notToName);
        return ResponseEntity.status(HttpStatus.OK).body(notToName);
    }

    @GetMapping("/lessThanPrice/{price}")
    public  ResponseEntity<List<Product>> getLessThanPrice(@PathVariable Integer price){
        List<Product> lessThanPrice = queryMethodService.getLessThanPrice(price);
        log.info("요청 가격보다 저렴한 Product => {}",lessThanPrice);
        return ResponseEntity.status(HttpStatus.OK).body(lessThanPrice);
    }

}
