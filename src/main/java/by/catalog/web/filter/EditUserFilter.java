package by.catalog.web.filter;

import by.catalog.domain.User;
import by.catalog.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "EditProfileServlet")
public class EditUserFilter extends HttpFilter {
    private final UserService userService = new UserService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String name = req.getParameter("newName");
        String lastName = req.getParameter("newLastName");
        String login = req.getParameter("newLogin");
        String password = req.getParameter("newPass");
        String phone = req.getParameter("newPhone");
        if (req.getMethod().equals("GET")) {
            chain.doFilter(req, res);
        }
        if (req.getMethod().equals("POST")) {
            boolean b1 = name.equals("") || lastName.equals("") || login.equals("") || password.equals("") || phone.equals("");
            boolean b2 = userService.checkUserByLogin(login) && !currentUser.getLogin().equals(login);
            if (b1) {
                String message = "Enter all required data";
                req.setAttribute("messageEdit", message);
                req.setAttribute("currentUser", currentUser);
                getServletContext().getRequestDispatcher("/pages/editProfile.jsp").forward(req, res);
                return;
            }
            if (b2) {
                String message = "Login exists. Try another login";
                req.setAttribute("messageEdit", message);
                req.setAttribute("currentUser", currentUser);
                getServletContext().getRequestDispatcher("/pages/editProfile.jsp").forward(req, res);
                return;
            }
            chain.doFilter(req, res);
        }
    }
}
