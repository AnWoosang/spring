package hello.core.lifecycle;

public class NetworkClient {

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
}
