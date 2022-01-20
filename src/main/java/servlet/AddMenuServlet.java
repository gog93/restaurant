package servlet;

import manager.MenuManager;
import model.Menu;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addMenu")

public class AddMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User users = (User) req.getSession().getAttribute("user");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        MenuManager menuManager = new MenuManager();
        menuManager.addMenu(Menu.builder()
                .name(name)
                .description(description)

                .build());
        req.getSession().setAttribute("msg", "menu was added");
        resp.sendRedirect("/managerHome");

    }
}
