package cn.hxzy.company.servlet.admin;


import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.NewsService;
import cn.hxzy.company.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/showNews")
public class AdminShowNewsServlet extends HttpServlet {
    UsersService usersService = new UsersService();
    NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

            List<Users> user = usersService.getAll();
            req.setAttribute("user", user);

            PageObj<News> count = newsService.findAll(pageObj);

            req.setAttribute("news", count);
            req.getRequestDispatcher("/WEB-INF/jsp/admin/showNews.jsp").forward(req, resp);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PageObj<News> pageObj = new PageObj<>();
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String usersId = req.getParameter("usersId");
            String date = req.getParameter("date");

            if (id != null && id != "") {
                News usersById = newsService.getById(Integer.parseInt(id));
                List<News> userList = new ArrayList<>();
                userList.add(usersById);
                pageObj.setList(userList);

                req.setAttribute("news", pageObj);
            }
            if (name != null && name != "") {
                PageObj<News> users = newsService.getByName(pageObj,name);

                req.setAttribute("count", users);
                req.setAttribute("news", users);
            }
            if (usersId != null && usersId != "") {
                PageObj<News> byId = newsService.findByUsersId(pageObj,Integer.parseInt(usersId));
                req.setAttribute("count", byId);
                req.setAttribute("news", byId);
            }
            if (date != null && date != "") {
                PageObj<News> byDate = newsService.getByDate(pageObj,date);
                req.setAttribute("count", byDate);
                req.setAttribute("news", byDate);
            }
            List<Users> user = usersService.getAll();
            req.setAttribute("user", user);

            req.getRequestDispatcher("/WEB-INF/jsp/admin/showNews.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
