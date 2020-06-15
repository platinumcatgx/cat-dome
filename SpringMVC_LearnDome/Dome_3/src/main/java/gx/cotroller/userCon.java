package gx.cotroller;

import gx.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("user")
public class userCon {

    @RequestMapping("/testAjax")
    public void t4(@RequestBody String body){
        System.out.println("执行了..."+body);
    }

    @RequestMapping("/testAjax2")
    public @ResponseBody
    User t5(@RequestBody User user){
        System.out.println("执行了..."+user);
        User u = new User();
        u.setUsername("张三丰");
        u.setPassword("武当第一");
        u.setAge(100);
        return u;
    }

}
