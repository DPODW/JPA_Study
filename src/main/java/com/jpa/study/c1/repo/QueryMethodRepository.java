package com.jpa.study.c1.repo;

import com.jpa.study.c1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryMethodRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);

    Product findByStock(Integer stock);

    Long countByName(String name);

    /**
     * TODO: 쿼리 메소드 더 사용해보기 + 설명 주석 달기
     * */

}
