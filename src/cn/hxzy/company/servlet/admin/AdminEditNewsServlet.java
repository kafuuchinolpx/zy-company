package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.service.NewsService;
import cn.hxzy.company.service.UsersService;
import cn.hxzy.company.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/editNews")
public class AdminEditNewsServlet extends HttpServlet {
    NewsService newsService=new NewsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                News usersById = newsService.getById(Integer.parseInt(id));
                req.setAttribute("data", usersById);
                req.getRequestDispatcher("/WEB-INF/jsp/admin/editNews.jsp").forward(req, resp);
                return;
            }
            req.getRequestDispatcher("/WEB-INF/jsp/admin/editNews.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String value = req.getParameter("value");
            if (id != null && id != "") {
                News news = new News(Integer.parseInt(id), name, value);
                newsService.newsUpdate(news);
            }
            resp.sendRedirect("showNews");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
