package pl.javastart.servlets;

import pl.javastart.domain.Privilages;
import pl.javastart.domain.User;
import pl.javastart.sql.UsersSQL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by oem on 2016-01-27.
 */
public class Register extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("password2");
        String email = request.getParameter("email");
        User user = new User(username, password, email, Privilages.standard);

        try  {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Strona", "postgres",
                    "qwerty");

            UsersSQL sql = new UsersSQL(connection);
            if(sql.selectByUsername(username) == false) {
                sql.add(user);
                connection.close();
                response.sendRedirect("registered.jsp");
            }else
                response.sendRedirect("regExist.jsp");

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request,response);
    }

}