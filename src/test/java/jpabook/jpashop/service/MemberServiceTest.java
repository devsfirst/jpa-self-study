package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // JUnit실행 시 spring과 같이 엮어서 실행하도록
@SpringBootTest // spring boot를 띄우고 실행하도록
@Transactional // 테스트 종료 시 rollback 하도록
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(false) // @Transactional이 있으면 기본적으로 rollback을 함. insert 쿼리를 보기 위해 false로
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long savedID = memberService.join(member);

        // then
        assertEquals(member, memberRepository.findOne(savedID));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then

    }
}