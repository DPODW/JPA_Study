package com.jpa.study.c1.repo;


import com.jpa.study.c1.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
