package gx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class clq implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        MyException me = null;
        if (me instanceof  MyException){
            e = (MyException)me;
        }else {
            e = new Exception("系统正在维护...");
        }
        System.out.println(e.getMessage());
        ModelAndView view = new ModelAndView();
        view.addObject("error",e.getMessage());
        view.setViewName("error");
        return view;
    }
}
