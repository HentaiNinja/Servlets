package pl.javastart.sql;

import pl.javastart.domain.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oem on 2016-01-27.
 */
public class AddressSQL {

    private Statement statement;
    private Connection connection;
    private PreparedStatement insertAddressStmt;
    private PreparedStatement updateAddressStmt;

    public AddressSQL(Connection connection){
        this.setConnection(connection);
        try {
            statement = connection.createStatement();
            this.insertAddressStmt = connection.prepareStatement("INSERT INTO address (id,addresstype, voidvodeship, city ,zipcode, street, housenumber,person_id) VALUES (NULL,?,?,?,?,?,?,?);");
            this.updateAddressStmt = connection.prepareStatement("UPDATE address SET addresstype = ?,voidvodeship  = ?, city = ?, zipcode = ?, street = ?, housenumber = ? WHERE id = ?;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Address address, int id){
        boolean i = false;
        try {
            statement.execute("insert into address (addresstype, voidvodeship, city, zipcode, street, housenumber, person_id) values ('" +
                    address.getType().toString() + "', '" +
                    address.getRegion().toString() + "', '" +
                    address.getCity() + "', '" +
                    address.getZipcode() + "', '" +
                    address.getStreet() + "', '" +
                    address.getNumber() + "', '" +
                    id + "');");
            i = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public boolean update(Address address, String id){
        boolean i = false;
        try {
            statement.execute("UPDATE address SET addresstype ='" +  address.getType() +
                    "', voidvodeship ='" +  address.getRegion() +
                    "', city ='" +  address.getCity() +
                    "', zipcode ='" +  address.getZipcode() +
                    "', street ='" +  address.getStreet() +
                    "',housenumber = '" +  address.getNumber()+
                    "' WHERE id = " + id +";");

            i = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public boolean delete(String id){
        boolean x = false;
        try {
            statement.execute("DELETE FROM address WHERE id = '" + id + "';");
            x = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<Address> selectAll(int id){
        List<Address> addresses = new ArrayList<Address>();
        try {
            ResultSet result = statement.executeQuery("SELECT id , addresstype, voidvodeship ,city , zipcode, street , housenumber  FROM address WHERE person_id='" +id+ "' ;");
            while(result.next()){
                Address address = new Address();
                address.setId(result.getInt(1));
                address.setType(result.getString(2));
                address.setRegion(result.getString(3));
                address.setCity(result.getString(4));
                address.setZipcode(result.getString(5));
                address.setStreet(result.getString(6));
                address.setNumber(result.getString(7));
                addresses.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}