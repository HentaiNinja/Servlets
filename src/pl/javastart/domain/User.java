package pl.javastart.domain;

/**
 * Created by oem on 2016-01-27.
 */
public class User {

    private String username;
    private String password;
    private String email;
    private Privilages status;


    public User(){
        super();
    }

    public User(String username, String password, String email, Privilages status){
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setStatus(status);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Privilages getStatus() {
        return status;
    }

    public void setStatus(Privilages status) {
        this.status = status;
    }
}
