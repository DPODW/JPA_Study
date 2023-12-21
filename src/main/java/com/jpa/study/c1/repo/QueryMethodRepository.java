package com.jpa.study.c1.repo;

import com.jpa.study.c1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryMethodRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);

    Product findByStock(Integer stock);

    Long countByName(String name);

    Boolean existsByNumber(Long number);

    List<Product> findTop2ByName(String name);
    /*findFirst 와 동일한 기능을 함(상단의 몇개를 검색)*/

    List<Product> findByNameNot(String name);
    /* 정확하게는 findByNameIsNot 이지만, Is 는 생략 가능하다. */

    List<Product> findByPriceLessThan(Integer price);
    /* 요청 가격보다 저렴한(낮은) price 를 가진 Product 반환.
    * OrderByPriceDesc ~ Asc 와 같은 차순 정렬 가능 (Than 뒤에 붙히면 된다)
    * */


}
