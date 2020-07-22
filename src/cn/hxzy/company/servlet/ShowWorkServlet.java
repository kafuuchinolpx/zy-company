package cn.hxzy.company.servlet;

import cn.hxzy.company.entity.Works;
import cn.hxzy.company.service.WorksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class ShowWorkServlet extends HttpServlet {
    WorksService worksService=new WorksService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                Works getid = worksService.getId(Integer.parseInt(id));
                System.out.println(getid);
                req.setAttribute("works", getid);
                req.getRequestDispatcher("/WEB-INF/jsp/showWork.jsp").forward(req,resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
