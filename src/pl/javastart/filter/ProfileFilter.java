package pl.javastart.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oem on 2016-01-27.
 */
public class ProfileFilter implements Filter {
    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String user = (String) req.getSession().getAttribute("privilages");

        if(user !="standard" || user !="premium" || user !="admin"){
            res.sendRedirect("brakdostepu.jsp");
        }
        chain.doFilter(req,res);

    }


    @Override
    public void destroy(){
        // TODO Auto-generated method stub

    }
}