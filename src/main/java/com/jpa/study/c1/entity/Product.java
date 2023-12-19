package com.jpa.study.c1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity //해당 클래스가 엔티티임을 (JPA 용도) 임을 선언하는 어노테이션
@Table(name="product") /* 테이블과 매핑하는 어노테이션 (엔티티 클래스는 테이블과의 매핑이 기본이라,
                          해당 어노테이션은 '어느 테이블(이름) 에 매핑할 것인지' 명시하는 용도로 자주 쓰임.
                          해당 어노테이션을 생략할 시 => class 이름으로 테이블을 검색하고 매핑함 */
public class Product {

    @Id
    /* 테이블의 기본값 (유일한거) 지정 어노테이션. 모든 엔티티는 기본값을 필수로 요구한다.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* 해당 필드의 값을 어떤 방식으로 자동 생성할 것인지 지정하는 어노테이션. @Id 와 같이 쓰임
    *  (strategy = GenerationType. ? ) 물음표 전 까지의 코드가 방식을 묻는 코드 (공통)
    * 현재는 IDENTITY (기본값 생성을 DB에 위임. AUTO_INCREMENT )
    * 다른 자동 생성 방법들은 책 109 페이지 참고
    *  */
    private Long number;


    @Column(nullable = false)
    /* DB 컬럼과 매핑을 하게 해주는 어노테이션. 기본적으로 매핑을 지원하기 때문에, 특별한 설정을 하지 않을것이라면
    * 해당 어노테이션은 생략해도 된다. 현재는 NULL 을 비허용 하는 설정을 추가하였다. (길이 제한과 유니크 설정도 가능)
    * */
    private String name;


    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    /* @Transient : 엔티티 클래스 (해당 클래스) 에 선언은 되어 있지만, DB 와 교류가 필요없을때 해당 어노테이션을 사용하면
    * 특정 필드는 DB 이용에서 제외 가능.
    * */

}
