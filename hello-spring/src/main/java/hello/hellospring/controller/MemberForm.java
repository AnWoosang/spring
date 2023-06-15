package hello.hellospring.controller;

public class MemberForm {

    // template 파일에 있는 name이 매칭이 되어 들어온다.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
