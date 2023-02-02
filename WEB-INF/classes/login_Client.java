package login;

public class login_Client {
    int idClient;
    String username;
    String password;

    public login_Client(int idClient, String username, String password) {
        this.idClient = idClient;
        this.username = username;
        this.password = password;
    }

    public login_Client() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
