package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


// InitializingBean과 DisposableBean은 스프링에만 의존하기 때문에 순수 자바에서는 사용할 수 없다.
public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 연결이 되어있을 때 호출이 가능한 메소드
    public void call(String msg) {
        System.out.println("call: " + url + " message: " + msg);
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }


//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
}
