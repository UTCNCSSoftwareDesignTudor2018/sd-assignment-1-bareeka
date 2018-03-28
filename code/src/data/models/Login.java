package data.models;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class Login {
    private int id;
    private String username;
    private String password;
    private int role;

    public Login(){

    }

    public Login(int id, String name, String pw, int role) {
        this.id = id;
        this.username = name;
        this.password = pw;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String toString(){
        return "Login [id=" + id + ", username=" + username + "password=****";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}