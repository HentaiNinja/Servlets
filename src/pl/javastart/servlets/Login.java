package pl.javastart.servlets;

import pl.javastart.sql.UsersSQL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by oem on 2016-01-27.
 */
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.getSession().setAttribute("username", username);
        HttpSession session = request.getSession();
        System.out.println(username);


        try {

            String URL = "jdbc:postgresql://localhost:5432/Strona";
            String log = "postgres";
            String pass = "qwerty";
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL,log,pass);
            UsersSQL sql = new UsersSQL(connection);

            if(sql.selectByUsername(username))
                if(sql.selectByUsernameAndPassword(username, password)) {
                    session.setAttribute("id", sql.getIdByLogin(username));
                    session.setAttribute("privilages", sql.getPrivilages(username));
                    System.out.println(session.getAttribute("id"));
                    response.sendRedirect(request.getContextPath() + "/Profile");
                }
                else{
                    response.sendRedirect("wrongpass.jsp");
                }
            else response.sendRedirect("wronglogin.jsp");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        doPost(request, response);
    }



}