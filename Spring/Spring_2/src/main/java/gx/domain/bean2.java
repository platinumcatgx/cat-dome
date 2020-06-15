package gx.domain;

import java.util.Date;

public class bean2 {
    private String naem;
    private int age;
    private Date date;

    @Override
    public String toString() {
        return "bean1{" +
                "naem='" + naem + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }


    public void setNaem(String naem) {
        this.naem = naem;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
