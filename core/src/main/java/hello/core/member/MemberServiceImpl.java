package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Impl은 관례로 사용, 구현체가 하나만 있을 경우, 인터페이스뒤에 Impl이라고 붙힘
 */
@Component
public class MemberServiceImpl implements MemberService {

    // join에서 save를 호출하면 다형성에 의해서 인터페이스의 save가 아니라 MemoryMemberRepository에서 save가 호출이 된다.
    // DIP를 잘 준수하고 있는가? 아니지 왜? MemberRepository는 추상화에 의존하는게 맞지만 생성객체인 MemoryMemberRepository는 구현체에 의존하게 된다.(DIP위반)
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
