package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.service.MembersService;
import cn.hxzy.company.service.UsersService;
import cn.hxzy.company.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/admin/addMember")
@MultipartConfig
public class AdminAddMemberServlet extends HttpServlet {
    MembersService membersService = new MembersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/admin/addMember.jsp").forward(req, resp);
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

                String name = req.getParameter("name");
                String age = req.getParameter("age");
                String work = req.getParameter("work");
                membersService.memberAdd(new Members(name, Integer.parseInt(age), imagePath, work));
                resp.sendRedirect("addMember");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
