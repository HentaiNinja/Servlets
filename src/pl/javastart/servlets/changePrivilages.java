package pl.javastart.servlets;

import pl.javastart.sql.UsersSQL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by oem on 2016-01-27.
 */
public class changePrivilages extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String username = request.getParameter("username");
        String action = request.getParameter("action");
        String status = request.getParameter("status");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Strona", "postgres",
                    "qwerty");
            UsersSQL sql = new UsersSQL(connection);

            if(action.equals("add")){
                sql.update(username, status);
                connection.close();
                out.println("Uprawienia zostały zmienione");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.close();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        doPost(request, response);
    }

}