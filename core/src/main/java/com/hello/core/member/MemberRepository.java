package com.hello.core.member;

import com.hello.core.member.Member;

// 인터페이스는 클래스들이 필수로 구현해야하는 추상 자료형이다. (객체 사용 가이드라인)
// 인터페이스는 구현 소스를 가질 수 없다. 상수와 추상 메소드만 가질 수 있다.
// 자식 클래스들은 모두 이 기능들을 구현해야한다.
public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
