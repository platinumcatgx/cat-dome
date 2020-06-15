package gx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(path = "/user")
@SessionAttributes("mmm")
public class AonnTest {

    @RequestMapping(path = "/norp")
    public String noRP(@RequestParam(name = "name", required = false) String username) {
        System.out.println(username);
        return "ok";
    }

    @RequestMapping(path = "/noRB")
    public String noRB(@RequestBody(required = true) String name) {
        System.out.println(name);
        return "ok";
    }

    @RequestMapping(path = "/userid/{id}")
    public String noPV(@PathVariable(value = "id", required = true) String id) {
        System.out.println(id);
        return "ok";
    }

    @RequestMapping(path = "/set")
    public String SetAttribute(Model model) {
        System.out.println("set");
        model.addAttribute("mmm", "张三");
        return "ok";
    }

    @RequestMapping(path = "/get")
    public String GetAttribute(ModelMap modelMap) {
        System.out.println("get");
        String msg = (String) modelMap.get("mmm");
        System.out.println(msg);
        return "ok";
    }

    @RequestMapping(path = "/del")
    public String DelAttribute(SessionStatus sessionStatus) {
        System.out.println("del");
        sessionStatus.setComplete();
        return "ok";
    }

}
