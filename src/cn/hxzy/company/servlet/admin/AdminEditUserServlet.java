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

@WebServlet("/admin/editUser")
public class AdminEditUserServlet extends HttpServlet {
    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                Users usersById = usersService.getById(Integer.parseInt(id));
                req.setAttribute("users", usersById);
                req.getRequestDispatcher("/WEB-INF/jsp/admin/editUser.jsp").forward(req, resp);
                return;
            }
            req.getRequestDispatcher("/WEB-INF/jsp/admin/showUser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String loginName = req.getParameter("loginName");
            String loginPassword = req.getParameter("loginPassword");
            String password = Md5Util.MD5(loginPassword);
            if (id != null && id != "") {
                Users users = new Users(Integer.parseInt(id), loginName, password);
                usersService.userUpdate(users);
            }
            resp.sendRedirect("showUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
