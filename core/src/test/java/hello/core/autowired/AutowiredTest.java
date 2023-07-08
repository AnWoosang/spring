package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }


    static class TestBean{

        @Autowired(required = false)
        void setNoBean(Member member) {
            System.out.println("member = " + member);
        }

        @Autowired
        void setNoBean1(@Nullable Member member1){
            System.out.println("member1 = " + member1);
        }

        @Autowired
        void setNoBean2(Optional<Member> member2){
            System.out.println("member2 = " + member2);
        }
    }
}
