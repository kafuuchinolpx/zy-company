package cn.hxzy.company.servlet;

import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.service.MembersService;
import cn.hxzy.company.service.NewsService;
import cn.hxzy.company.service.WorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService();
        WorksService worksService = new WorksService();
        MembersService membersService = new MembersService();

        try {
            List<News> news = newsService.getAll();
            List<Works> works = worksService.getAll();
            List<Members> members = membersService.getAll();

            req.setAttribute("news", news);
            req.setAttribute("works", works);
            req.setAttribute("members",members);
            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
