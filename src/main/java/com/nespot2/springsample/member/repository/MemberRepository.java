package com.nespot2.springsample.member.repository;

import com.nespot2.springsample.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findFirstByEmail(String email);
}
