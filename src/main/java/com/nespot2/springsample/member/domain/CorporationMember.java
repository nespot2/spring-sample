package com.nespot2.springsample.member.domain;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CorporationMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String bizno;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public CorporationMember(String bizno, OffsetDateTime createdAt, Member member) {
        this.bizno = bizno;
        this.createdAt = createdAt;
        this.member = member;
    }
}
