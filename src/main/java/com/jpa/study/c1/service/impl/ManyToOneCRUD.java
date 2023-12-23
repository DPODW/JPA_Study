package com.jpa.study.c1.service.impl;

import com.jpa.study.c1.entity.Member;
import com.jpa.study.c1.entity.Team;
import com.jpa.study.c1.repo.MemberRepository;
import com.jpa.study.c1.repo.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ManyToOneCRUD {

    private final MemberRepository memberRepository;

    private final TeamRepository teamRepository;


    public ManyToOneCRUD(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    public void saveMemberAndTeam(){
        Team team1 = new Team();
        team1.setId("team3");
        team1.setName("팀3");
        log.info("Team 객체 저장 => {}",team1);
        teamRepository.save(team1);

        /* Team 객체를 저장합니다. 외래키 설정이 되어있어서 Member 테이블에서 Team 객체 접근이 가능합니다 */
        Member member1 = new Member();
        member1.setId("member4");
        member1.setUsername("회원4");
        member1.setTeam(team1);
        log.info("member1 객체 저장 => {}",member1);
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setId("member5");
        member2.setUsername("회원5");
        member2.setTeam(team1);
        log.info("member2 객체 저장 => {}",member2);
        memberRepository.save(member2);
    }

    public void findTeamToMember(){
        Optional<Member> member4 = memberRepository.findById("member4");
        Team team = member4.get().getTeam();
        /* ID 를 이용하여 member 가져오고, member 에서 Team 을 꺼내옵니다.
        *  getReferenceById(getOne 대체 메소드) 를 사용하면 반환 타입을 Member (list 아님) 로 할수있다.
        *  */
        log.info("member ID 로 검색해서 얻은 Team 정보 => {}",team);
        /** 이렇게 객체를 통해 연관된 엔티티를 조회하는 것을 '객체 그래프 탐색' 이라고 한다 **/
    }

    public void updateTeamToMember(){
        Member member4 = memberRepository.getReferenceById("member4");
        log.info("수정 전 객체 => {}",member4);
        Team team1 = teamRepository.getReferenceById("team2");

        member4.setTeam(team1);

        Member resultMember = memberRepository.save(member4);
        log.info("수정 후 객체 => {}",resultMember);
    }

    public void deleteRelation(){
        /* 연관관계 제거 (연관관계 엔티티 값을 NULL 로 설정해서 제거한다.)*/
        Member member1 = memberRepository.getReferenceById("member1");
        member1.setTeam(null);
        memberRepository.save(member1);
        log.info("member1 => {}",member1);

        /**
         * 연관된 엔티티 (Team) 을 삭제하려면, 먼저 연관관계를 제거해야 한다.
         * ex) 팀1 에는 회원1과 회원2가 소속되어있다. 여기서 팀1을 제거하려면
         * 먼저 회원1과 회원2의 연관관계를 제거해야한다.
         **/
    }

    public void findMemberToTeam(){
        Team team1 = teamRepository.getReferenceById("team1");
        List<Member> team1Members = team1.getMembers();
        team1Members.stream().map(name -> {
            log.info("{}",name.getUsername());
            return "ok";
        }).collect(Collectors.toList());
       /* Team 객체에서 Member 를 찾는 메소드. (팀에 속한 회원 찾기)
        * 팀에 속한 회원은 다수이기 때문에 stream 으로 반복해서 찾아야함
        * */
    }


}
