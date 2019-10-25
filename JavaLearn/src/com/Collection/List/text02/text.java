package com.Collection.List.text02;

import java.util.ArrayList;
import java.util.List;

public class text {
    public static void main(String[] args) {
        dog dog1 =new dog(5,"阿拉斯加");
        dog dog2 =new dog(5,"哈士奇");
        dog dog3 =new dog(5,"拉布阿达");
        dog dog4 =new dog(5,"雪纳瑞");

        List list = new ArrayList();
        if(list.size()>0){
            System.out.println("集合不为空");
        }
        list.add(dog1);
        list.add(dog2);
        list.add(dog3);
        list.add(dog4);


        System.out.println("数量："+list.size());

        for(int i=0;i<list.size();i++){
            dog dog =(dog)list.get(i);
            System.out.println(dog);
        }

    }
}
