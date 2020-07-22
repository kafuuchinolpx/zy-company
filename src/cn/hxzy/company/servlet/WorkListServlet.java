package cn.hxzy.company.servlet;
import cn.hxzy.company.entity.News;
import cn.hxzy.company.entity.Works;
import cn.hxzy.company.entity.vo.PageObj;
import cn.hxzy.company.service.WorksService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/workList")
public class WorkListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WorksService worksService = new WorksService();

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

            req.setAttribute("users", count);

            req.setAttribute("works", count);
            req.getRequestDispatcher("/WEB-INF/jsp/workList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
