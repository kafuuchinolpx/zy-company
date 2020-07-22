package cn.hxzy.company.servlet.admin;


import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.service.WorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/admin/addWork")
@MultipartConfig
public class AdminAddWorkServlet extends HttpServlet {
    WorksService worksService = new WorksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/admin/addWork.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String path = this.getServletContext().getRealPath("/img");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            Part ap = req.getPart("image");

            if (null != ap) {
                String[] split = ap.getSubmittedFileName().split("\\.");
                String pathname = System.currentTimeMillis() + "." + split[split.length - 1];
                ap.write(path + "/work/" + pathname);
                String imagePath = "/img/work/" + pathname;
                req.getSession().getAttribute("loginUser");
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String value = req.getParameter("value");
                worksService.workAdd(new Works(name, imagePath, value, new Date(), Integer.parseInt(id)));
                resp.sendRedirect("addWork");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
