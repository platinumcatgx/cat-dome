package com.company;
import static java.lang.System.out;
public class Main {

    public static void main(String[] args) {
        person person = new person();

        try {
            person.setAge(25);
            person.setSex("男");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
