package com.jpa.study.c1.entity.extend;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AttributeOverride(name="createdBy", column = @Column(name = "CarMakeBy")) // 해당 방법으로, 부모 클래스의 컬럼을 재정의 할수 있다.
public class Car extends BaseEntity{

    @Id
    @Column(name = "CAR_ID")
    private String  id;
}
