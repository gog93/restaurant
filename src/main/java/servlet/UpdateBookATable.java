package servlet;

import lombok.SneakyThrows;
import manager.BookAtableManager;
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
import java.util.Date;

@WebServlet(urlPatterns = "/updateBookATable")

public class UpdateBookATable extends HttpServlet {
    private BookAtableManager bookAtableManager = new BookAtableManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookATableId = Integer.parseInt(req.getParameter("id"));
        BookATable book = bookAtableManager.getBookAtableById(bookATableId);
        req.setAttribute("bookATable", book);
        req.getRequestDispatcher("/WEB-INF/updateBookATable.jsp").forward(req, resp);
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));
        User user = (User) req.getSession().getAttribute("user");

        BookATable bookById = bookAtableManager.getBookAtableById(bookId);
        if (bookById != null) {

            String number = req.getParameter("number");
            String authorName = req.getParameter("authorName");
            String date = req.getParameter("date");
            try {
                BookATable bookATable = BookATable.builder()
                        .number(number)
                        .date(sdf.parse(date))
                        .user(user)
                        .build();
                bookAtableManager.updateBook(bookATable);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            req.getSession().setAttribute("msg", "book was updated");
            resp.sendRedirect("/user");
        }

    }
}
