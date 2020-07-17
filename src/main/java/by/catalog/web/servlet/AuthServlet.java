package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "AuthServlet")

public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        User user = userService.checkPasswordByLogin(login, password);
        if (user != null) {
            if (user.getPassword().equals("admin") && user.getLogin().equals("admin")){
                    req.getSession().setAttribute("Admin", user);
                    getServletContext().getRequestDispatcher("/pages/adminAccount.jsp").forward(req, resp);
                }
            req.getSession().setAttribute("currentUser", user);
            req.getSession().setAttribute("checkAuth", true);
            resp.sendRedirect("/");
        } else {
            String message = userService.authMessageService(login, password);
            req.setAttribute("messageAuth", message);
            getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }
    }
}