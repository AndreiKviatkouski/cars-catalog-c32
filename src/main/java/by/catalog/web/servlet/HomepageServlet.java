package by.catalog.web.servlet;

import by.catalog.domain.Advert;
import by.catalog.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = "/")
public class HomepageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        List lastAdverts = advertService.getLastAdverts();
        ArrayList advertList = new ArrayList<>(lastAdverts);
        req.setAttribute("advertList", advertList);

        List MarkList = advertService.returnSortMark();
        req.setAttribute("AllAdvertMarks", MarkList);

        String mark = req.getParameter("mark");
        if (mark != null) {
            if (mark.equals("anyMark")) {
                req.setAttribute("hadChosen", false);
            } else {
                List<String> modelByMark = advertService.returnModelByMark(mark);
                req.setAttribute("modelByMark", modelByMark);
                req.setAttribute("mark", mark);
                req.setAttribute("hadChosen", true);
                List<Advert> advertByMark = advertService.findAdvertByMark(mark);
                req.setAttribute("advertList", advertByMark);
            }
        }

        Calendar calendar = new GregorianCalendar();
        Date data = calendar.getTime();

        Date time = (Date) getServletContext().getAttribute("name");
        resp.getWriter().println(time);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(df);

        req.setAttribute("calendar", df + "  " + data);
        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdvertService advertService = new AdvertService();
        String markCar = req.getParameter("mark");
        req.setAttribute("mark", markCar);
        String model = req.getParameter("model");
        List<Advert> advertByModel = advertService.findAdvertByModel(markCar, model);
        req.setAttribute("advertList", advertByModel);
        req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
    }
}