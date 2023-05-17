package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 두 객체가 필요, 멤버 조회, 할인정책
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 굉장히 잘 설계되어있다. SRP를 잘 지키고 있기 때문 즉, 구현체의 변화가 필요한 경우 구현체 자체의 변경으로만 기능을 지원할 수 있음
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 등급만 넘겨도 되지만, 확장성 등 프로젝트의 상황을 고려하여 적절하게 넘겨주면 된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
