package com.nespot2.springsample.security.service;

import com.nespot2.springsample.member.domain.Member;
import com.nespot2.springsample.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findFirstByEmail(username)
                .map(this::mapUser)
                .orElseThrow(() -> new BadCredentialsException(""));
    }

    private UserDetails mapUser(Member member) {
        return User.builder()
                .roles(member.getRole().name())
                .username(member.getEmail())
                .password(member.getPassword())
                .build();
    }


}
