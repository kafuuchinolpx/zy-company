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

@WebServlet("/login")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            UsersService usersService = new UsersService();

            String loginName = req.getParameter("loginName");
            String loginPassword = req.getParameter("loginPassword");
            //获取账号密码
            String passwordMd5 = Md5Util.MD5(loginPassword);//使用MD5加密密码
            Users users = usersService.login(loginName, passwordMd5);//后台验证加密后的账号密码
            if (users != null) {
                req.getSession().setAttribute("loginUser", users);
                resp.sendRedirect("admin");
                System.out.println("有用户登录,账户名:" + users.getLoginName());
                return;
            }

            req.setAttribute("prompt", "账号或密码错误,请检查您的账号或密码");
            resp.sendRedirect("login");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
