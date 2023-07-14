package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    /* 출력결과 : null이 나오는 이유? - 생성자로 초기화를 할때는 url에 대한 설정이 없기 때문이다.
    생성자 호출, url = null
    connect: null
    call: null message: 초기화 연결 메시지
    생성자 호출, url = null
    connect: null
    call: null message: 초기화 연결 메시지
    */
    @Test
    void lifeCycleTest() {
        // ConfigurableApplicationContext가 AnnotationConfigApplicationContext의 상위에 있기 때문에 자식클래스를 생성해서 부모클래스에 대입하는 것이 가능하다.
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        // 닫는 메소드는 잘 쓰지 않기 때문에 기본 메서드에서는 지원하지 않는다.
        // 따라서 Application Context 대신 ConfigurableApplicationContext를 사용해준다. - 우리가 ApplicationContext를 사용할 때 close를 사용하는 경우가 거의 없다. -> 제공 x
        ac.close();
    }


    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
