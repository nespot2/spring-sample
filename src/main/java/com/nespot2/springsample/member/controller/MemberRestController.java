package com.nespot2.springsample.member.controller;

import com.nespot2.springsample.api.domain.ApiResult;
import com.nespot2.springsample.member.domain.dto.MemberDto;
import com.nespot2.springsample.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member-api")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResult> create(@Valid @RequestBody MemberDto memberDto) {
        memberService.createMember(memberDto);
        return ApiResult.ok().mapperResponseEntity();
    }

}
