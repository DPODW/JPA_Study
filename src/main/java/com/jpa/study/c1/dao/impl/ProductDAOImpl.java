package com.jpa.study.c1.dao.impl;

import com.jpa.study.c1.dao.ProductDAO;
import com.jpa.study.c1.entity.Product;
import com.jpa.study.c1.repo.ProductRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectProduct = productRepository.getReferenceById(number);
        return selectProduct;
      /*
       * 책에는 getById() 를 사용하고 있는데, 해당 메소드는 deprecated 되었다.
       * 대안책으로는 getReferenceById , findById 두가지의 메소드가 존재한다.
       * findById 는 내부적 동작 방식이 살짝 다르나, getReferenceById 는 getById 의 대체제다.
       * getById 와 동일한 기능을 원한다면 getReferenceById 를 사용해야 한다.
       * https://velog.io/@kimgunwooo/getById-vs-findById
       * */
    }

    @Override
    public Product updateProduct(Long number, String name) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);

        Product updateProduct;
        if(selectProduct.isPresent()){
            //selectProduct 가 NULL 인지 검사(isPresent : 객체가 null 이면 false , 아니면 true)

            Product product = selectProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        }else{
            throw  new Exception();
        }
        return updateProduct;
    }


    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);

        if(selectProduct.isPresent()){
            Product product = selectProduct.get();
            productRepository.delete(product);
        }else {
            throw new Exception();
        }
    }
}
