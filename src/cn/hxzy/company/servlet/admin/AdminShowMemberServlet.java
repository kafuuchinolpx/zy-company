package cn.hxzy.company.servlet.admin;

import cn.hxzy.company.entity.Members;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.MembersService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/showMember")
public class AdminShowMemberServlet extends HttpServlet {
    MembersService membersService = new MembersService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {


            PageObj<Members> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }
            PageObj<Members> count = membersService.findAll(pageObj);
            req.setAttribute("member", count);

            req.getRequestDispatcher("/WEB-INF/jsp/admin/showMember.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String work = req.getParameter("work");
        PageObj<Members> pageObj = new PageObj<>();
        try {
            if (id != null && id != "") {
                Members usersById = membersService.getById(Integer.parseInt(id));
                List<Members> member = new ArrayList<>();
                member.add(usersById);
                pageObj.setList(member);
                req.setAttribute("member", pageObj);
            }


            if (name != null && name != "") {
                List<Members> name1 = membersService.memberByName(name);
                pageObj.setList(name1);
                req.setAttribute("member", pageObj);
            }


            if (work != null && work != "") {
                List<Members> work1 = membersService.memberByWork(work);
                pageObj.setList(work1);
                req.setAttribute("member", pageObj);
            }

            req.getRequestDispatcher("/WEB-INF/jsp/admin/showMember.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
