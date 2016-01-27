package pl.javastart.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oem on 2016-01-27.
 */
public class PremiumFilter implements Filter {
    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String user = (String) req.getSession().getAttribute("user");
        String privilages = (String) req.getSession().getAttribute("privilages");
        System.out.println(user);

        if(user == null ){
            res.sendRedirect("brakuprawnien.jsp");

            if(privilages == "standard"){
                res.sendRedirect("brakuprawnien.jsp");}
            System.out.println("brak dostepu bo nie ma uprawnien");
        }
        chain.doFilter(req,res);

    }


    @Override
    public void destroy(){
        // TODO Auto-generated method stub

    }
}