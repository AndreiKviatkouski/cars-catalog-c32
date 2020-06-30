package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.domain.User;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "YouAdvertsServlet", urlPatterns = "/pers/youAdvert")
public class YouAdvertServlet extends HttpServlet {

    private AdvertService advertService = new AdvertService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        List<Advert> allAdverts = advertService.getAllUserAdvert(currentUser.getId());
        req.setAttribute("allYouAdverts", allAdverts);
        getServletContext().getRequestDispatcher("/pages/youAdvert.jsp").forward(req, resp);
    }
}
