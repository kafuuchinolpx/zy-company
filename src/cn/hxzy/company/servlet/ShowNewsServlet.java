package cn.hxzy.company.servlet;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showNews")
public class ShowNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService();
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                News getId = newsService.getAllById(Integer.parseInt(id));
                req.setAttribute("news", getId);
                req.getRequestDispatcher("/WEB-INF/jsp/showNews.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
