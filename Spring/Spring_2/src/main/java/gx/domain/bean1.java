package gx.domain;

import java.util.Date;

public class bean1 {
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

    public bean1(String naem, int age, Date date) {
        this.naem = naem;
        this.age = age;
        this.date = date;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
