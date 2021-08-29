package servlet;

import manager.UserManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserManager userManager = new UserManager();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getUserByPasswordAndEmail(email, password);
        if (user == null) {
            req.getSession().setAttribute("msg", "wrong email or password ");
            resp.sendRedirect("login.jsp");
        } else {
            req.getSession().setAttribute("user", user);
            if (user.getType() == UserType.RESTAURANT) {
                resp.sendRedirect("/manegerhome");
            } else {
                resp.sendRedirect("/user");
            }
        }
    }
}
