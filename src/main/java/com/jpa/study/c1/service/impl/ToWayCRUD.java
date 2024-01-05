package com.jpa.study.c1.service.impl;

import com.jpa.study.c1.entity.Member;
import com.jpa.study.c1.entity.Team;
import com.jpa.study.c1.repo.MemberRepository;
import com.jpa.study.c1.repo.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ToWayCRUD {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public ToWayCRUD(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    public void toWaySave(){
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        teamRepository.save(team1);

        Member member = new Member();
        member.setId("member1");
        member.setUsername("회원1");
        member.setTeam(team1); //연관관계 설정 (member -> team)
//        team1.getMembers().add(member); 연관관계 설정 (team -> member)
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team1); //연관관계 설정 (member2 -> team)
//        team1.getMembers().add(member2); 연관관계 설정 (team -> member)
        memberRepository.save(member2);

       /**
        * member 에 Team 을 설정해주고
        * Team 에는 member 를 소속시켜준다.
        * (양쪽 다 관계를 맺는 양방향 설정 완료)
        * ---------------------------------
        * 그러나 저렇게 수동적인 방식으로 양방향을 설정하면 둘 중 하나만 호출 하는 등, 실수를 유발한다.
        * 고로, 저 2줄의 코드를 하나인 것 처럼 사용하는게 안전하다.
        *  member DTO 의 setTeam 에  [team -> member] 관계 코드를 추가하였다.
        **/

        List<Member> members = team1.getMembers();
        log.info("members size => {}",members.size());

        /*
        * 양방향 연관관계는 양쪽에서 모두 이루어져야한다. (member -> team , team -> member)
        * 양쪽에서 모두 이루어지게 하지 않으면, members (팀에 소속된 회원 변수) 가 0 을 리턴하게 된다. (팀에 소속된 회원이 없다는 오류)
        * 그렇기 때문에, 양방향은 양쪽 다 관계를 설정해야한다.
        * */
    }

}
