package gx.domain;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;

    private User2 user2;
    public User2 getUser2() {
        return user2;
    }
    public void setUser2(User2 user2) {
        this.user2 = user2;
    }


    private List<String> list;
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    private Map<String,User2> map;
    public Map<String, User2> getMap() {
        return map;
    }

    public void setMap(Map<String, User2> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", user2=" + user2 +
                ", list=" + list +
                ", map=" + map +
                '}';
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
