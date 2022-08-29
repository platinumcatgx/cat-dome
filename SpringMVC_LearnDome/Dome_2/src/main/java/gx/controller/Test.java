package gx.controller;

import gx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("user")
public class Test {

    @RequestMapping("/t1")
    public String t1(String name){
        System.out.println("t1=>"+name);
        return "ok";
    }

    @RequestMapping("/t2")
    public String t2(User user){
        System.out.println(user);
        return "ok";
    }

    @RequestMapping("/t3")
    public String t3(Date date){
        System.out.println(date);
        return "ok";
    }

    @RequestMapping("/t4")
    public String t4( @RequestParam(required = true ,name = "name")  String username){
        System.out.println(username);
        return "ok";
    }

}
