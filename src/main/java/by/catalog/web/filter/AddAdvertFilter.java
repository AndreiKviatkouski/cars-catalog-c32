package by.catalog.web.filter;

import by.catalog.service.AdvertService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "AddAdvertFilter", servletNames = "AddAdvertServlet")

public class AddAdvertFilter extends HttpFilter {

    AdvertService advertService = new AdvertService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, NumberFormatException {

        if (req.getMethod().equals("POST")) {
            String mark = req.getParameter("mark");
            String model = req.getParameter("model");
            String color = req.getParameter("color");
            String year = req.getParameter("year");
            String prise = req.getParameter("prise");

            try {
                if (mark != null || model != null || color != null || year != null || prise != null) {
                    if (Integer.parseInt(year) < 2021 && Integer.parseInt(year) > 1950 && Double.parseDouble(prise) > 0) {
                        chain.doFilter(req, res);
                    }
                } else {
                    List listMark = advertService.returnSortMark();
                    req.setAttribute("listMark", listMark);
                    req.setAttribute("checkAdvert", "Data not entered or entered incorrectly");
                    getServletContext().getRequestDispatcher("/pages/addAdvert.jsp").forward(req, res);
                }
            } catch (NumberFormatException e) {
                List listMark = advertService.returnSortMark();
                req.setAttribute("listMark", listMark);
                req.setAttribute("checkAdvert", "Data not entered or entered incorrectly");
                getServletContext().getRequestDispatcher("/pages/addAdvert.jsp").forward(req, res);
            }
        } else chain.doFilter(req, res);
    }
}
