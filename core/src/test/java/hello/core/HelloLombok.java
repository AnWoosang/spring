package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private Long id;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setId(1L);
        helloLombok.setName("HelloLombok");

        System.out.println("helloLombok = " + helloLombok);
    }
}
