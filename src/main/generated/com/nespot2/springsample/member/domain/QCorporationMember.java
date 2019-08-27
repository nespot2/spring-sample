package com.nespot2.springsample.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCorporationMember is a Querydsl query type for CorporationMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCorporationMember extends EntityPathBase<CorporationMember> {

    private static final long serialVersionUID = -407246633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCorporationMember corporationMember = new QCorporationMember("corporationMember");

    public final StringPath bizno = createString("bizno");

    public final DateTimePath<java.time.OffsetDateTime> createdAt = createDateTime("createdAt", java.time.OffsetDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QCorporationMember(String variable) {
        this(CorporationMember.class, forVariable(variable), INITS);
    }

    public QCorporationMember(Path<? extends CorporationMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCorporationMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCorporationMember(PathMetadata metadata, PathInits inits) {
        this(CorporationMember.class, metadata, inits);
    }

    public QCorporationMember(Class<? extends CorporationMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

