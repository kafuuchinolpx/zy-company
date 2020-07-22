package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.service.MembersService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteMember")
public class AdminMembersDeleteServlet extends HttpServlet {
    MembersService membersService = new MembersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            membersService.deleteById(Integer.parseInt(id));
            resp.sendRedirect("showMember");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
