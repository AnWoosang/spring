package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// TDD(Test-Driven Development) 테스트 주도 개발, 개발 이전에 구현할 기능들을 테스트할 틀을 먼저 만들고 나서 이에 맞게 개발하는 방

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void save() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        memberRepository.save(member);
        Member result = memberRepository.findByName("spring").get();

        // then
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);

    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}