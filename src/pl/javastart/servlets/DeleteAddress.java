package pl.javastart.servlets;

import pl.javastart.sql.AddressSQL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by oem on 2016-01-27.
 */
public class DeleteAddress extends HttpServlet{

    private static final long serialVersionUID = 1L;
    String id;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String type = request.getParameter("type");
        String region = request.getParameter("region");
        String city = request.getParameter("city");
        String zipcode = request.getParameter("zipcode");
        String street = request.getParameter("street");
        String number = request.getParameter("number");
        String id =(String)request.getSession().getAttribute("addressid");
        System.out.println(id);


        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Strona", "postgres",
                    "qwerty");
            AddressSQL sql = new AddressSQL(connection);
            if(sql.delete(id)){

                response.sendRedirect("addgood.jsp");
            }
            else{
                response.sendRedirect("addbad.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String id3 = (String) request.getSession().getAttribute("id");
        id = String.valueOf(id3);
        doPost(request, response);
    }
}