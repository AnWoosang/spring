package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    @DisplayName("상태가 있는 서비스 테스트")
    void 상태가있는서비스테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

        // 두번째의 호출에서 price의 상태를 바꾸었기 때문에 userA의 price정보도 같이 바뀌게 되었다. (동시성 문제 발생)
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

//        assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
        assertThat(userAPrice).isNotEqualTo(userBPrice);
    }


    static class TestConfig{
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}