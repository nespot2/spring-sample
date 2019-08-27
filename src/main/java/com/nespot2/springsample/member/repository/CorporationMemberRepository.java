package com.nespot2.springsample.member.repository;

import com.nespot2.springsample.member.domain.CorporationMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationMemberRepository extends JpaRepository<CorporationMember, Long> {

}
