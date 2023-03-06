/**
 * 
 * Project name: 
 * Initial date: 4/01/2021
 * Modification date: 
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

public class User {
    public static String user = null;
    public static String password = null;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
