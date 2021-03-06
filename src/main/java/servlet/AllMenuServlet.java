package servlet;

import manager.MenuManager;
import model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allMenu")

public class AllMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuManager menuManager = new MenuManager();
        List<Menu> getMenus = menuManager.getAll();
        req.setAttribute("menu", getMenus);
        req.getRequestDispatcher("allMenu.jsp").forward(req, resp);

    }
}
