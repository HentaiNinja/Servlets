package pl.javastart.servlets;

import pl.javastart.domain.Address;
import pl.javastart.sql.AddressSQL;

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
public class AddAddress extends HttpServlet{

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            HttpSession session = request.getSession();
            String type = request.getParameter("type");
            String region = request.getParameter("region");
            String city = request.getParameter("city");
            String zipcode = request.getParameter("zipcode");
            String street = request.getParameter("street");
            String number = request.getParameter("number");
            Address address = new Address(type, region, city, zipcode, street, number);

            String URL = "jdbc:postgresql://localhost:5432/Strona";
            String log = "postgres";
            String pass = "qwerty";
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL,log,pass);
            AddressSQL sql = new AddressSQL(connection);
            int id = (Integer)request.getSession().getAttribute("id");
            System.out.println(id);
            if(sql.add(address, id)){
                response.sendRedirect("addgood.jsp");
            }
            else{
                response.sendRedirect("addbad.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }

}