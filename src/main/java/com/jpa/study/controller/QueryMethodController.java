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

}
