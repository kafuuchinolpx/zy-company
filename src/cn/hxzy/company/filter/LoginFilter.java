package cn.hxzy.company.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //过滤器初始化方法
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //由于ServletRequest是HttpServletRequest父类，无法获取请求的URI 所以强制转换为HttpServletRequest
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if ( request.getRequestURI().endsWith("index")||request.getRequestURI().endsWith("login")) {
            filterChain.doFilter(request, response);
            //放行
            return;
        } else {//从session里面获取用户的角色
            if (request.getSession().getAttribute("loginUser") == null) {
                response.sendRedirect("index");
                //未登录，重定向到主页页
            } else {
                filterChain.doFilter(request, response);
                //登录了
                return;
            }


        }
    }

    @Override
    public void destroy() {

    }
}