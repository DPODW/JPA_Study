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
    /*
    * TODO: 양방향 실패 테스트 해보기. (Team 연관관계 어노테이션 삭제로 테스트 가능)
    * TODO: 코드 분석하기
    * 코드는 정상 작동 됌
    * */

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
        member.setTeam(team1);
        team1.getMembers().add(member);
        memberRepository.save(member);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setUsername("회원2");
        member2.setTeam(team1);
        team1.getMembers().add(member2);
        memberRepository.save(member2);

        List<Member> members = team1.getMembers();
        log.info("members size => {}",members.size());
    }

}
