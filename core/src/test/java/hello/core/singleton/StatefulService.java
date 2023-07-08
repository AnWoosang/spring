package hello.core.singleton;

public class StatefulService {

//    private int price; // 동시성 문제를 해결하기 위해 공유되는 변수를 제거한다.

    public int order(String name, int price) {
        System.out.println("name = " + name + " price : " + price);
//        this.price = price; // 여기가 문제 !
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
