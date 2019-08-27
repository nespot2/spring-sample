package com.nespot2.springsample.member.domain;

import com.nespot2.springsample.common.YesNo;
import com.nespot2.springsample.member.domain.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final PasswordEncoder passwordEncoder;

    public Member createMember(MemberDto memberDto) {
        return Member.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .role(MemberRole.USER)
                .createdAt(OffsetDateTime.now())
                .modifiedAt(OffsetDateTime.now())
                .deleted(YesNo.NO)
                .build();
    }
}
