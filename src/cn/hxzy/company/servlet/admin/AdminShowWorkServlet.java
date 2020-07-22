package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Users;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.UsersService;
import cn.hxzy.company.service.WorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/showWork")
public class AdminShowWorkServlet extends HttpServlet {
    WorksService worksService = new WorksService();
    UsersService usersService = new UsersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PageObj<Works> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }
            PageObj<Works> count = worksService.findAll(pageObj);

            req.setAttribute("works", count);

            List<Users> user = usersService.getAll();
            req.setAttribute("user", user);


            req.getRequestDispatcher("/WEB-INF/jsp/admin/showWork.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {

            PageObj<Works> pageObj = new PageObj<>();
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String usersId = req.getParameter("usersId");
            String date = req.getParameter("date");


            if (id != null && id != "") {
                Works usersById = worksService.getId(Integer.parseInt(id));
                List<Works> worksList = new ArrayList<>();
                worksList.add(usersById);
                pageObj.setList(worksList);
                req.setAttribute("works", pageObj);

            }
            if (name != null && name != "") {
                List<Works> users = worksService.getByName(name);
                pageObj.setList(users);
                req.setAttribute("works", pageObj);
            }
            if (usersId != null && usersId != "") {
                List<Works> byId = worksService.findById(Integer.parseInt(usersId));
                pageObj.setList(byId);
                req.setAttribute("works", pageObj);
            }
            if (date != null && date != "") {
                List<Works> byDate = worksService.getByDate(date);
                pageObj.setList(byDate);
                req.setAttribute("works", pageObj);
            }


            List<Users> user = usersService.getAll();
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/admin/showWork.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
