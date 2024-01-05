package com.jpa.study.c1.entity.extend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AttributeOverrides({
        @AttributeOverride(name="createdBy", column = @Column(name = "CycleMakeBy")),
        @AttributeOverride(name="createdDate", column = @Column(name = "CycleMakeTime"))
}) //두개 이상의 부모 클래스 재정의는 위의 방식으로 구현한다.
public class Cycle extends BaseEntity{

    @Id
    @Column(name = "Cycle_ID")
    private String  id;
}
