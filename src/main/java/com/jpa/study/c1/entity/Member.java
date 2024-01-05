package com.jpa.study.c1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String  id;


    private String username;

    @Setter(AccessLevel.PROTECTED) //롬복에서 자동 생성해주는 Setter 를 커스텀해서 사용해야 할 때 붙히는 어노테이션
    @ManyToOne //다대일 관계임을 명시하는 어노테이션 (필수)
    @JoinColumn(name = "TEAM_ID") //외래키 매핑시 사용하는 어노테이션 (필수)
    private Team team;
    /*
    * MEMBER 테이블의 TEAM_ID 와 TEAM 테이블의 TEAM_ID 는 외래키 연관 관계를 가지고 있다.
    * 그렇기 때문에 JoinColumn 으로 외래키 필드를 명시해주어야 한다.
    * */

    public void setTeam(Team team){
        if(this.team !=null){
            this.team.getMembers().remove(this);
        }
       /*
        * 만약 유지중인 관계(소속중인 기존 팀) 가 있다면, 제거한다.
        * 해당 로직을 넣지 않으면, 소속 중인 팀이 1개 이상이 되는 오류가 발생한다.
        * EX)  member.setTeam(team1); ,  member.setTeam(team2);
        *      이렇게 하였을때, 여전히 첫번째의 team1 이 조회되는 것이다. (수정되지 않음)
        * */

        this.team = team;
        team.getMembers().add(this);
       /* team 객체의 members 에 해당 member 를 삽입한다. (양방향)
        * 이러한 방법을 [연관관계 편의 메소드] 라고 한다.
        * */
    }



}
