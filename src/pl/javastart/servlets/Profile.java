package pl.javastart.servlets;

import pl.javastart.domain.Address;
import pl.javastart.sql.AddressSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by oem on 2016-01-27.
 */
public class Profile extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String text;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Statement statement;
        Connection connection;

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String username = (String) request.getSession().getAttribute("username");
        text = "<h3>Twoje adresy to: </h3><br><br>";
        HttpSession session = request.getSession();
        int id = 0;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Strona", "postgres",
                    "qwerty");
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("Select id From person where username = '" + username + "';");
            System.out.println("polaczenie do bazy dziala");

            while(result.next()) {
                id = result.getInt(1);
            }

            request.getSession().setAttribute("id", id);
            AddressSQL sql = new AddressSQL(connection);
            id = (int) session.getAttribute("id");
            System.out.println(id);
            System.out.println("laduje atrybut sesji");
            if (id == 0) {
                text = "ID JEST ROWNE ZERO ";
            } else {
                int i = 1;
                for (Address current : sql.selectAll(id)) {
                    i = current.getId();
                    text += "<b><li>" + current.getType() + ":</b> " + current.getRegion() + ", " + current.getZipcode() + ", " + current.getCity() + ", " +
                            current.getStreet() + ", " + current.getNumber() + " <a href='editAddress.jsp?addressid=" + i + "'>Edytuj adres</a> <a href='/DeleteAddress?addressid=" + i + "'>Usu� adres</a></li><br>";

                    System.out.println("powinno pobrac liste adresow");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(text);
        request.getSession().setAttribute("lista", text);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");
        dispatcher.forward(request,response);




    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }


}