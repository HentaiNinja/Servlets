package pl.javastart.sql;

import pl.javastart.domain.Privilages;
import pl.javastart.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oem on 2016-01-27.
 */
public class UsersSQL {

    private Statement statement;
    private Connection connection;
    private PreparedStatement insertUserStmt;
    private PreparedStatement selectAllUserStmt;

    public UsersSQL(Connection connection){
        this.setConnection(connection);
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void add(User user) throws Exception{
        boolean i = false;

        PreparedStatement ps = null;
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Strona", "postgres",
                "qwerty");
        String searchQuery = "INSERT INTO person (username , password, email,privilages ) VALUES(?,?,?,?);";
        ps = connection.prepareStatement(searchQuery);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, "standard");
        ps.execute();
    }


    public void update(String username, String status){
        try {
            statement.execute("UPDATE  person SET PRIVILaGES = '" + status + "' WHERE username = '" + username + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String username){
        try {
            statement.execute("DELETE FROM person WHERE username = '" + username + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> selectAll(){
        List<User> users = new ArrayList<User>();
        try {
            ResultSet result = selectAllUserStmt.executeQuery();
            while(result.next()){
                User user = new User();
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setEmail(result.getString("email"));
                user.setStatus((Privilages) result.getObject("status"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean selectByUsername(String username) throws Exception{
        boolean i = false;

        PreparedStatement ps = null;
        String URL = "jdbc:postgresql://localhost:5432/Strona";
        String log = "postgres";
        String pass = "qwerty";
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(URL,log,pass);
        String searchQuery = "SELECT * FROM  person WHERE username=? ";
        ps = connection.prepareStatement(searchQuery);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        boolean login = rs.next();
        if(login == true){
            i = true;
            return i;
        }
        else {
            return i;
        }


    }

    public boolean selectByUsernameAndPassword(String username, String password)throws Exception{
        boolean i = false;

        PreparedStatement ps = null;
        String URL = "jdbc:postgresql://localhost:5432/Strona";
        String log = "postgres";
        String pass = "qwerty";
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(URL,log,pass);
        String searchQuery = "SELECT * FROM  person WHERE username=? AND password = ?";
        ps = connection.prepareStatement(searchQuery);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean login = rs.next();
        if(login == true){
            i = true;
            return i;
        }
        else {
            return i;
        }

    }

    public  int getIdByLogin(String username) throws SQLException {
        String query;
        query = "select id from person where username = '" + username + "';";
        ResultSet rs = statement.executeQuery(query);

        int id = 0;
        while (rs.next())
            id = rs.getInt("id");
        return id;
    }
    public  String getPrivilages(String username) throws SQLException {
        String query;
        query = "select privilages from person where username = '" + username + "';";
        ResultSet rs = statement.executeQuery(query);
        String priv = null;
        while(rs.next()){
            priv = rs.getString("privilages");
        }
        return priv;
    }


    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}