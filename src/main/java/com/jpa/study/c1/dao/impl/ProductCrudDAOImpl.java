package com.jpa.study.c1.dao.impl;

import com.jpa.study.c1.dao.ProductCrudDAO;
import com.jpa.study.c1.entity.Product;
import com.jpa.study.c1.repo.ProductCrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductCrudDAOImpl implements ProductCrudDAO {

    private final ProductCrudRepository productCrudRepository;

    public ProductCrudDAOImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productCrudRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
        Product selectProduct = productCrudRepository.getReferenceById(number);
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
        Optional<Product> selectProduct = productCrudRepository.findById(number);

        Product updateProduct;
        if(selectProduct.isPresent()){
            //selectProduct 가 NULL 인지 검사(isPresent : 객체가 null 이면 false , 아니면 true)

            Product product = selectProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updateProduct = productCrudRepository.save(product);
        }else{
            throw  new Exception();
        }
        return updateProduct;
    }
    /*
     * JPA 에는 Update 기능만을 수행하는 메소드가 존재하지 않는다.
     * 위와 같이, 수정하고 싶은 데이터가 존재할시
     * 1. 해당 데이터 존재 유무 체크 (null)
     * 2. 존재할시, get 을 통해서 객체 가져옴
     * 3. 수정 (set~~)
     * 4. 다시 save
     * => find 메소드를 통해 객체를 검색하고 영속성 컨텍스트에 추가한다.
     * 영속성 컨텍스트에서 값을 새롭게 수정하고 다시 저장한다.
     * 최종적으로 변경된 값이 저장된다. (더티 체크)
     * */


    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productCrudRepository.findById(number);

        if(selectProduct.isPresent()){
            Product product = selectProduct.get();
            productCrudRepository.delete(product);
        }else {
            throw new Exception();
        }
    }
}
