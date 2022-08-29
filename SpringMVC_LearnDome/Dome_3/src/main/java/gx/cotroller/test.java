package gx.cotroller;

import gx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
    public class test {
    private String ret = "ok";

    /**
     * String返回值
     * @param model
     * @return
     */
    @RequestMapping("/t1")
    public String t1(Model model) {
        System.out.println("执行了...");
        User user = new User();
        user.setUsername("张三1");
        user.setPassword("158424");
        user.setAge(10);
        model.addAttribute("user", user);
        return ret;
    }

    /**
     * void返回值,跳转到默认目录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/t2_0")
    public void t2_0(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了t2_0...");
    }

    /**
     * 转发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/t2")
    public void t2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了t2...");
        request.getRequestDispatcher("/ok.jsp").forward(request,response);
    }

    /**
     * 重定向
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/t2_2")
    public void t2_2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了t2_2...");
        response.sendRedirect(request.getContextPath()+"/ok.jsp");
    }

    /**
     * 直接响应输出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/t2_3")
    public void t2_3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了t2_3...");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("张飞");
    }

    /**
     * 返回ModelAndView对象
     * @return
     */
    @RequestMapping("/t2_4")
    public ModelAndView t2_4() {
        System.out.println("执行了...");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("张三1");
        user.setPassword("158424");
        user.setAge(10);
        mv.addObject("user3",user);

        mv.setViewName("t2_0");
        return mv;
    }

    @RequestMapping("t3")
    public String t3(){
        System.out.println("执行了t3...");
        return "forward:/t2_0.jsp";
    }

    @RequestMapping("t3_1")
    public String t3_1(){
        System.out.println("执行了t3...");
        return "redirect:t2_0,jsp";
    }

    @RequestMapping("t4")
    public String t4(@RequestBody String body){
        System.out.println("执行了..."+body);
        return ret;
    }

}
