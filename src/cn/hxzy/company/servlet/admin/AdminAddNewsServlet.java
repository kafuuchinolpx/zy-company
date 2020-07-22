package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.service.NewsService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/admin/addNews")
public class AdminAddNewsServlet extends HttpServlet {
    NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/admin/addNews.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().getAttribute("loginUser");

            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String value = req.getParameter("value");
            newsService.newsAdd(new News(name, value, new Date(), Integer.parseInt(id)));
            resp.sendRedirect("addNews");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
