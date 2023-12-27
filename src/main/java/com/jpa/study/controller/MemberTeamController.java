package com.jpa.study.controller;

import com.jpa.study.c1.service.impl.ManyToOneCRUD;
import com.jpa.study.c1.service.impl.ToWayCRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/MemberTeam")
public class MemberTeamController {

    private final ManyToOneCRUD manyToOneCRUD;
    private final ToWayCRUD toWayCRUD;

    public MemberTeamController(ManyToOneCRUD manyToOneCRUD, ToWayCRUD toWayCRUD) {
        this.manyToOneCRUD = manyToOneCRUD;
        this.toWayCRUD = toWayCRUD;
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

    @PostMapping("/toWaySave")
    public void toWaySave(){
        toWayCRUD.toWaySave();
    }
}
