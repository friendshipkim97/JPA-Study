package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // junit을 사용할 때 스프링이랑 같이 엮어서 사용하고자 할때사용한다.
@SpringBootTest
@Transactional // 롤백을 하기 위해서 test에 붙이면 롤백이됨, 서비스 리포지토리 제외
public class MemberServiceTest {

        @Autowired MemberService memberService;
        @Autowired
        MemberRepositoryOld memberRepositoryOld;

        @Test
        public void join(){
            // given
            Member member = new Member();
            member.setName("kim");

            // when
            Long savedId = memberService.join(member);

            // then
            Assertions.assertEquals(member, memberRepositoryOld.findOne(savedId));
        }

        @Test(expected = IllegalStateException.class)
        public void duplicateException() throws Exception{
            // given
            Member member1 = new Member();
            member1.setName("kim");
            Member member2 = new Member();
            member2.setName("kim");

            // when
            memberService.join(member1);
//            try{
//                memberService.join(member2); // 예외가 발생해야 한다.
//            } catch (IllegalStateException e){ // IllegalStateException 예외면 return이 되는 것이다.
//                return;
//            }
            memberService.join(member2);

            // then
            fail("예외가 발생해야 한다."); // fail을 쓰면 여기오면 안됨

        }

    }