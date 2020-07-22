package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.Users;
import cn.hxzy.company.service.UsersService;
import cn.hxzy.company.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addUser")
public class AdminAddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/admin/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UsersService usersService = new UsersService();
            String loginName = req.getParameter("loginName");
            String loginPassword = req.getParameter("loginPassword");
            String passwordMd5 = Md5Util.MD5(loginPassword);
            usersService.userAdd(new Users(loginName, passwordMd5));
            resp.sendRedirect("addUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
