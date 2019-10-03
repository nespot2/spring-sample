package com.nespot2.springsample.member.domain;

import com.nespot2.springsample.common.domain.YesNo;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    private OffsetDateTime lastVisitAt;

    private OffsetDateTime deletedAt;

    @Column(nullable = false)
    @Enumerated
    private YesNo deleted;

    @Builder
    public Member(String name, String email, String password, MemberRole role, OffsetDateTime modifiedAt, OffsetDateTime createdAt, OffsetDateTime lastVisitAt, OffsetDateTime deletedAt, YesNo deleted) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.lastVisitAt = lastVisitAt;
        this.deletedAt = deletedAt;
        this.deleted = deleted;
    }
}