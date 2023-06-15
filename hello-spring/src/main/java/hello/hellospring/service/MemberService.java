package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// 보통 서비스 관련 클래스의 경우에는 비즈니스 로직에 부합하는 클래스명을 사용해야한다. 소통을 위해서
// 서비스는 비즈니스 의존적으로 설계되는 것이 바람직하고, 리포지토리는 개발스럽게 기계적으로 설계되는 것이 좋다

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // 이와 같이 Constructor를 구성하는 것이 DI(Dependency Injection, 의존성 주입) 이라고 한다.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     */
    public Long join(Member member) {
        // Optional 객체를 바로 반환하는것은 권장되는 방법이 아니다.
        //        Optional<Member> result = memberRepository.findByName(member.getName());

        validateDuplicateMember(member); // 중복회원 검증

        member = memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
