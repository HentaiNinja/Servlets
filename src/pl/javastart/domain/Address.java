package pl.javastart.domain;

/**
 * Created by oem on 2016-01-27.
 */
public class Address {

    private String type;
    private String region;
    private String city;
    private String zipcode;
    private String street;
    private String number;
    private int id;

    public Address(){

    }

    public Address(String type, String region, String city, String zipcode, String street, String number){
        this.setType(type);
        this.setRegion(region);
        this.setCity(city);
        this.setZipcode(zipcode);
        this.setStreet(street);
        this.setNumber(number);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
