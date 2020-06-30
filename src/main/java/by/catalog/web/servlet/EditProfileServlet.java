package by.catalog.web.servlet;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/pers/editProfile")
public class EditProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("currentUser", currentUser);
        req.getServletContext().getRequestDispatcher("/pages/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String newName = req.getParameter("newName");
        String newLastName = req.getParameter("newLastName");
        String newLogin = req.getParameter("newLogin");
        String newPass = req.getParameter("newPass");
        String newPhone = req.getParameter("newPhone");
        req.getSession().setAttribute("currentUser", new User(currentUser.getId(), newName, newLastName, newLogin, newPass, newPhone));
        userService.editUserById(new User(currentUser.getId(), newName, newLastName, newLogin, newPass, newPhone));
        req.getSession().setAttribute("messageUpdate", "Update successfully");
        resp.sendRedirect("/pers");
    }
}

