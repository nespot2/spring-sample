package com.nespot2.springsample.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 195284389L;

    public static final QMember member = new QMember("member1");

    public final DateTimePath<java.time.OffsetDateTime> createdAt = createDateTime("createdAt", java.time.OffsetDateTime.class);

    public final EnumPath<com.nespot2.springsample.common.YesNo> deleted = createEnum("deleted", com.nespot2.springsample.common.YesNo.class);

    public final DateTimePath<java.time.OffsetDateTime> deletedAt = createDateTime("deletedAt", java.time.OffsetDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.OffsetDateTime> lastVisitAt = createDateTime("lastVisitAt", java.time.OffsetDateTime.class);

    public final DateTimePath<java.time.OffsetDateTime> modifiedAt = createDateTime("modifiedAt", java.time.OffsetDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<MemberRole> role = createEnum("role", MemberRole.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

