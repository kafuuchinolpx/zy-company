package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteUser")
public class AdminUsersDeleteServlet extends HttpServlet {
    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            usersService.deleteById(Integer.parseInt(id));
            resp.sendRedirect("showUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
