package servlet;

import manager.BookAtableManager;
import manager.UserManager;
import model.BookATable;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@WebServlet(urlPatterns = "/bookATable")

public class BookATableServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        User user = (User) req.getSession().getAttribute("user");
        BookAtableManager bookAtableManager = new BookAtableManager();
        String number = (req.getParameter("number"));
        String date = req.getParameter("date");


        try {
            BookATable bookATable = BookATable.builder()
                    .number(number)
                    .date(sdf.parse(date))
                    .user(user)
                    .build();
            bookAtableManager.addBookATable(bookATable);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (user == null) {
            req.getSession().setAttribute("msg", "please login");
            resp.sendRedirect("/login");
        } else {
            req.getSession().setAttribute("msg", "book was added");
            resp.sendRedirect("/");
        }
    }
}
