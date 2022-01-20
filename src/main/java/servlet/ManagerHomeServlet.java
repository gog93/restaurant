package servlet;

import manager.BookAtableManager;
import manager.MenuManager;
import manager.UserManager;
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
import java.net.HttpCookie;
import java.util.List;

@WebServlet(urlPatterns = "/managerHome")
public class ManagerHomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        User sessionUser = (User) session.getAttribute("user");
        MenuManager menuManager = new MenuManager();
        UserManager userManager = new UserManager();
        User users = new User();
        BookAtableManager bookAtableManager = new BookAtableManager();
        List<User> getAllUser = userManager.getUsers();
        List<BookATable> getAllBookATable = bookAtableManager.getBookATable();
        List<Menu> getAllMenu = menuManager.getMenu();
        req.setAttribute("user", getAllUser);
        req.setAttribute("bookATable", getAllBookATable);
        req.setAttribute("menu", getAllMenu);
        req.setAttribute("sessionUser", sessionUser);
        req.getRequestDispatcher("manager.jsp").forward(req, resp);
    }
}
