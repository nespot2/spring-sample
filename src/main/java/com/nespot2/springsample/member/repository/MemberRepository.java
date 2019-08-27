package com.nespot2.springsample.member.repository;

import com.nespot2.springsample.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
