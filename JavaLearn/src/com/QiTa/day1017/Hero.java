package com.QiTa.day1017;

public class Hero {
    private String name;
    private jiNeng jn;

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public jiNeng getJn() {
        return jn;
    }

    public void setJn(jiNeng jn) {
        this.jn = jn;
    }
    public void gj(){
        System.out.println("攻击！！！");
        jn.use();
    }
}
