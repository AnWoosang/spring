package hello.core.singleton;

public class SingletonService {
    // 1. static 영역에 객체를 딱 1개 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요한 경우(기존에서 생성한 부분) 이 static 메소드를 통해서만 조회되도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private로 접근을 제한하여 외부에서 다른 인스턴스를 생성할 수 없도록 막는다.
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
