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
@ToString
@Entity
public class Team {

    @Id
    @Column(name="TEAM_ID")
    private String id;

    private String name;


    @OneToMany(mappedBy = "team") /* 일대다 관계이기 때문에 OneToMany 관계를 명시해야한다.
                                     mappedBy 해당 속성은 양방향일때 사용하는데, 반대쪽 매핑의 필드 이름을 적어야한다.
                                     반대쪽은 MEMBER 객체의 TEAM(Member.team) 이기 때문에 team 값을 설정했다. 여기는 Team.Member 이다*/
    private List<Member> members = new ArrayList<Member>();
    /* 일대다 관계는 여러 건과 연관관계를 받을수 있기 때문에 List 를 사용해야한다.*/
}
