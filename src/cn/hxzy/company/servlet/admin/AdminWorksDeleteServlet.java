package cn.hxzy.company.servlet.admin;
import cn.hxzy.company.service.WorksService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/deleteWork")
public class AdminWorksDeleteServlet extends HttpServlet {
    WorksService worksService = new WorksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            worksService.deleteById(Integer.parseInt(id));
            resp.sendRedirect("showWork");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
