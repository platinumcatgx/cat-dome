package com.QiTa.day1017;

public class test01 {


    public static void main(String[] args) {
        Hero h = new Hero();
        h.setName("后羿");
        h.setJn(new jiNeng() {
            @Override
            public void use() {

                System.out.println("胡~哈~呼呼~哈哈~~");

            }
        });
        h.gj();

    }
}
