import java.io.Serializable;

public class User implements Serializable {

    private String fullName;
    private String username;
    private String password;
    private int role;

 /*   public User() {
    }*/


    public User(String fullName,
                String username,
                String password,
                int role){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getFullName(){
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String toString() {
        return fullName + " [" +
                "Username = " + username + ", " +
                "Password = " + password + ", " +
                "Role = " + (role == 1? "admin" : "user") +
                "]";
    }
    }

