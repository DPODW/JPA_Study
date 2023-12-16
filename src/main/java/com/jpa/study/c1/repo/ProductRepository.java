package com.jpa.study.c1.repo;

import com.jpa.study.c1.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * JpaRepository : JPA 에서 제공하는 기본적인 공통 CRUD 메소드를 담고 있는 저장소다.
 * JpaRepository 의 기본값 타입은 <사용할 엔티티 Class , 엔티티 Class 의 @Id 타입> 으로 구성한다.
 * 우리가 사용할 repo(ProductRepository) 는 JpaRepository 의 기능을 상속 받는다.
 * 해당 클래스에 구현체는 필요없다. (Spring Data JPA 가 로딩 시점에서 구현체를 전부 만들어주는 방식)
 * */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
