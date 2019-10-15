package com.nespot2.springsample.item.repository;

import com.nespot2.springsample.SpringSampleApplication;
import com.nespot2.springsample.member.domain.Member;
import com.nespot2.springsample.member.domain.QMember;
import com.nespot2.springsample.order.domain.QSimpleOrder;
import com.nespot2.springsample.order.domain.SimpleOrder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = SpringSampleApplication.class)
public class ItemRepositoryTest {



    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void test(){




        entityManager.createQuery("SELECT m FROM Member m INNER JOIN SimpleOrder o ON m.id = o.id").getResultList();



    }

}