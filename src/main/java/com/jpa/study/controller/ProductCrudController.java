package com.jpa.study.controller;

import com.jpa.study.c1.data.ChangeProductNameDto;
import com.jpa.study.c1.data.ProductDto;
import com.jpa.study.c1.data.ProductResponseDto;
import com.jpa.study.c1.service.ProductCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductCrudController {

    private final ProductCrudService productCrudService;

    public ProductCrudController(ProductCrudService productCrudService) {
        this.productCrudService = productCrudService;
    }

    @GetMapping("/{selectNumber}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long selectNumber){
        ProductResponseDto productResponseDto = productCrudService.getProduct(selectNumber);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto){
        ProductResponseDto productResponseDto = productCrudService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto)throws Exception{
        ProductResponseDto productResponseDto = productCrudService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping("/{deleteNumber}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long deleteNumber) throws Exception{
        productCrudService.deleteProduct(deleteNumber);
        return ResponseEntity.status(HttpStatus.OK).body("정상 삭제");
    }
}
