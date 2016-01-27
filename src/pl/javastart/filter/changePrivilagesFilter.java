package pl.javastart.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oem on 2016-01-27.
 */
public class changePrivilagesFilter implements Filter {
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
        System.out.println(user);


        if(user != "admin"){
            res.sendRedirect("brakuprawnien.jsp");
            System.out.println("brak dostepu bo ma uprawnien lol");
        }
        chain.doFilter(req,res);

    }


    @Override
    public void destroy(){
        // TODO Auto-generated method stub

    }
}