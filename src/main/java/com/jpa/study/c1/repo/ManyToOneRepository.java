package com.jpa.study.c1.repo;

import com.jpa.study.c1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyToOneRepository extends JpaRepository<Long, Member> {
}
