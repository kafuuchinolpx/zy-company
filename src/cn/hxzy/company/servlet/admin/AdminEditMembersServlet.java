package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.service.MembersService;
import cn.hxzy.company.service.WorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/admin/editMember")
@MultipartConfig
public class AdminEditMembersServlet extends HttpServlet {
    MembersService membersService = new MembersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                Members usersById = membersService.getById(Integer.parseInt(id));
                req.setAttribute("members", usersById);
                req.getRequestDispatcher("/WEB-INF/jsp/admin/editMember.jsp").forward(req, resp);
                return;
            }
            req.getRequestDispatcher("/WEB-INF/jsp/admin/editMember.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String path = this.getServletContext().getRealPath("/img");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            Part ap = req.getPart("image");
                String[] split = ap.getSubmittedFileName().split("\\.");
                String pathname = System.currentTimeMillis() + "." + split[split.length - 1];
                ap.write(path + "/work/" + pathname);
                String imagePath = "/img/work/" + pathname;
                req.getSession().getAttribute("loginUser");
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String age = req.getParameter("age");
                String work = req.getParameter("work");

                membersService.newsUpdate(new Members(Integer.parseInt(id), name, Integer.parseInt(age), imagePath, work));
            resp.sendRedirect("showMember");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
