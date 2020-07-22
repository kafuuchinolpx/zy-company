package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/showUser")
public class AdminShowUserServlet extends HttpServlet {
    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {


            PageObj<Users> pageObj = new PageObj<>();

            String page = req.getParameter("page");
            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }

            PageObj<Users> count = usersService.findAll(pageObj);

            req.setAttribute("users", count);


            req.getRequestDispatcher("/WEB-INF/jsp/admin/showUser.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {

            PageObj<Users> pageObj = new PageObj<>();

            String page = req.getParameter("page");
            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }

            String id = req.getParameter("id");
            String loginName = req.getParameter("loginName");
            if (id != null && id != "") {
                Users byId = usersService.getById(Integer.parseInt(id));
                List<Users> users = new ArrayList<>();
                users.add(byId);
                pageObj.setList(users);
                req.setAttribute("users", pageObj);

            }


            if (loginName != null && loginName != "") {
                PageObj<Users> users = usersService.getByName(pageObj, loginName);
                req.setAttribute("count", pageObj);
                req.setAttribute("users", users);
            }
            req.getRequestDispatcher("/WEB-INF/jsp/admin/showUser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
