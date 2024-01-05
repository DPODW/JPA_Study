package com.jpa.study.c1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Team {

    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;


    @OneToMany(mappedBy = "team") /* 일대다 관계이기 때문에 OneToMany 관계를 명시해야한다.
                                     mappedBy 해당 속성은 양방향일때 사용하는데, 연관관계의 주인 필드를 입력하여야한다.
                                     주인 필드: 외래키가 있는 테이블의 외래키 지정 컬럼을 의미한다. 현재 Member DTO 에
                                     Team 필드가 DB 에서 외래키이기 때문에, 해당 필드명인 team 을 주인으로 지정하는 것이다.
                                     */
    private List<Member> members = new ArrayList<Member>();


    /* 연관관계 주인을 설정하는 이유: 양방향 상황에선 연관관계를 작업하는 곳이 두 곳(MEMBER , TEAM) 으로 늘어난다.
    * 이렇게 되면 둘 사의 차이가 발생할 수 있다. 그렇기 때문에 두 곳 중 한 곳에서만 외래키를 관리할수 있도록 해야한다.
    * 외래키를 관리하는 주인(MEMBER) 에선 외래키에 대한 CRUD 작업을 수행할 수 있고, 주인이 아닌 곳은 읽기 작업만 가능하다.
    * + 주인은 mappedBy 속성을 사용하지 않는다.
    * */
}
