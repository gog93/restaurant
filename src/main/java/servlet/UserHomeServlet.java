package servlet;

import manager.BookAtableManager;
import manager.MenuManager;
import model.BookATable;
import model.Menu;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user")

public class UserHomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        User users = new User();
        BookAtableManager bookATableManager = new BookAtableManager();
        MenuManager menuManager = new MenuManager();
        BookATable bookATable = new BookATable();
        BookATable allBookAtableById = bookATableManager.getBookAtableById(users.getId());
        List<Menu> allMenu = menuManager.getMenu();
        req.setAttribute("menu", allMenu);
        req.setAttribute("bookATable", allBookAtableById);
        req.getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
