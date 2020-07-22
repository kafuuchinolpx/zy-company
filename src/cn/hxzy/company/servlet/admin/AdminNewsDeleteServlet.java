package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteNews")
public class AdminNewsDeleteServlet extends HttpServlet {
    NewsService newsService=new NewsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        System.out.println("fuck");
        System.out.println(id);
        try {
            newsService.deleteById(Integer.parseInt(id));
            resp.sendRedirect("showNews");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
