package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class RootServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Util.addCorsHeader(resp);
        String name = req.getParameter("name");

        if(name==null || name.equals(""))
            req.setAttribute("message", "World");
        else
            req.setAttribute("message", name);

        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
    }


}