package com.jpa.study.c1.entity.extend;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass //공통 매핑 정보가 필요할때 사용하는 기능
public abstract class BaseEntity {

    private String createdBy;

    private LocalDateTime createdDate;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;


    /*
    * BaseEntity : 공통적으로 사용되는 컬럼 (생성 시간 , 생성 자 등등) 을 모두 통합해놓은 클래스. @MappedSuperclass 로 동작한다.
    * 실질적으로 DB 테이블과는 관계가 없으며, 자식 DTO 에서 중복되는 컬럼 정의를 줄이기 위해,
    * ㄴ EX) Car 클래스와 Cycle 클래스 둘다 공통적으로 생성 시간은 필요한데, 두군데 모두 중복 정의하면 비효율 적이다.
    *        고로 해당 클래스를 상속받으면, 공통 컬럼을 정의하지 않고 테이블 생성시 추가가 가능하다.
    *
    * 해당 클래스를 상속 받으면, 공통 속성은 정의하지 않아도, 테이블 생성시 같이 생성된다.
    * 물론 DB 테이블과는 관계가 없으므로, 해당 클래스로 조회를 하는 등의 작업은 불가능하다. (그냥 매핑 정보를 모아둔 역할)
    * 직접 생성해서 사용할 일 이 없기 때문에 추상 클래스 (abstract) 로 만드는것이 권장된다.
    * */
}
