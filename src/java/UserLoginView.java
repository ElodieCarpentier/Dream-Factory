
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.SessionScoped;
 
import org.primefaces.context.RequestContext;
 
@ManagedBean
@SessionScoped
public class UserLoginView {
     
    private String username;
     
    private String password;
 
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
   
    public void login(ActionEvent event) throws SQLException, ClassNotFoundException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            System.out.println("Reussi");
            ps = con.prepareStatement(
                    "select ID_USER, PWD FROM user where ID_USER= ? and PWD= ? ");
            ps.setString(1, username);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("ID_USER"));
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
                
            }
            else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        if (loggedIn){
            System.out.println("Loger in");
            lol();
        }
        context.addCallbackParam("loggedIn", loggedIn);
        
                
        System.out.println("Fin if");
                
    }
    public String lol(){
        return "welcomePrimefaces";
    }
    public String lol2(){
        return "index";
    }
}