package com.nespot2.springsample.member.service.impl;

import com.nespot2.springsample.member.domain.Member;
import com.nespot2.springsample.member.domain.MemberMapper;
import com.nespot2.springsample.member.domain.dto.MemberDto;
import com.nespot2.springsample.member.repository.MemberRepository;
import com.nespot2.springsample.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public void createMember(MemberDto memberDto) {
        final Member member = memberMapper.createMember(memberDto);
        memberRepository.save(member);
    }

}
