package com.jpa.study.c1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String  id;


    private String username;

    @ManyToOne //다대일 관계임을 명시하는 어노테이션 (필수)
    @JoinColumn(name = "TEAM_ID") //외래키 매핑시 사용하는 어노테이션 (필수)
    private Team team;
    /*
    * MEMBER 테이블의 TEAM_ID 와 TEAM 테이블의 TEAM_ID 는 외래키 연관 관계를 가지고 있다.
    * 그렇기 때문에 JoinColumn 으로 외래키 필드를 명시해주어야 한다.
    * */



}
