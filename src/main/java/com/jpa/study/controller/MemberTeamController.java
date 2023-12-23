package com.jpa.study.controller;

import com.jpa.study.c1.service.impl.ManyToOneCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/MemberTeam")
public class MemberTeamController {

    private final ManyToOneCRUD manyToOneCRUD;

    public MemberTeamController(ManyToOneCRUD manyToOneCRUD) {
        this.manyToOneCRUD = manyToOneCRUD;
    }

    @PostMapping("/save")
    public void MemberTeamSave(){
        manyToOneCRUD.saveMemberAndTeam();
    }

    @PostMapping("/findId")
    public void findTeamToMember(){
        manyToOneCRUD.findTeamToMember();
    }

    @PostMapping("/updateTeam")
    public void updateTeamToMember(){
        manyToOneCRUD.updateTeamToMember();
    }

    @PostMapping("/deleteTeam")
    public void deleteTeamRelation(){
        manyToOneCRUD.deleteRelation();
    }

    @PostMapping("/findMemberToTeam")
    public void findMemberToTeam(){
        manyToOneCRUD.findMemberToTeam();
    }

}
