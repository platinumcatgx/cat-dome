package gx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class index extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int max = 100;
        int min = -100;
        Random r = new Random();
        int s = r.nextInt(100);
        if (r.nextBoolean()) {
            s*=-1;
        }
        System.out.println(s);

        req.setAttribute("zhongjiang",s);
        if (s <= 0) {
            req.getRequestDispatcher("wzj.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("zj.jsp").forward(req, resp);
            resp.getOutputStream().print("中了"+s+"元");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
