package com.hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    // Test의 작성방법은 필수이다.
    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findmember = memberService.findMember(2L);

        // then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
