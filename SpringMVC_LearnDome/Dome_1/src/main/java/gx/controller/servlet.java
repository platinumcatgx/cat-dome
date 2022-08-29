package gx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
public class servlet implements Serializable {

    @RequestMapping(path = {"/hi"})
    public String ruMen(){
        System.out.println("入门执行");
        return "ok";
    }

}
