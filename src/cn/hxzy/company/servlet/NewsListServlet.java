package cn.hxzy.company.servlet;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newsList")
public class NewsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService();
        try {



            PageObj<News> pageObj = new PageObj<>();

            String page = req.getParameter("page");

            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }
            PageObj<News> count = newsService.findAll(pageObj);
            req.setAttribute("users", count);

            req.setAttribute("news", count);


            req.getRequestDispatcher("/WEB-INF/jsp/newsList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
