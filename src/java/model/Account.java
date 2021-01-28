package model;

public class Account {

    private int id;
    private String username, password;
    private boolean role;

    public Account() {
    }

    public Account(String username, String password, boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account(int id, String username, String password, boolean role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role ? "Admin" : "User";
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
