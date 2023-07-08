package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@RequiredArgsConstructor
@Component
public class OrderServiceImpl implements OrderService {

    // 두 객체가 필요, 멤버 조회, 할인정책
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/**
     private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     DIP, OCP 위반
     DIP 의존관계 역전 : 추상에 의존함과 더해 구체에도 의존을 하고 있음이 문제가 된다.
     OCP 열림과 닫힘 : 확장에는 열려있고 변경에는 닫혀있어야 하지만 클라이언트 단에 구체에 의존하고 있기 때문에 변경에도 열려있다.
*/
    // 굉장히 잘 설계되어있다. SRP를 잘 지키고 있기 때문 즉, 구현체의 변화가 필요한 경우 구현체 자체의 변경으로만 기능을 지원할 수 있음
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 등급만 넘겨도 되지만, 확장성 등 프로젝트의 상황을 고려하여 적절하게 넘겨주면 된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
