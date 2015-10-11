
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.bean.SessionScoped;

 
import org.primefaces.context.RequestContext;
 
@ManagedBean
@SessionScoped
public class UserLoginView{
     
    private String username;
     
    private String password;
    
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    private String image;
    
    private String statut;
    

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
                    "select ID_USER, PWD, IMAGE, STATUT, NOM_USER FROM user where ID_USER= ? and PWD= ? ");
            ps.setString(1, username);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                System.out.println(rs.getString("ID_USER"));
                image="Resources/"+rs.getString("IMAGE");
                statut=rs.getString("STATUT");
                nom=rs.getString("NOM_USER");
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue", username); 
            }
            else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Ce n'est pas les bons identifiants");
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
        if (username.equals("admin")){
            return "admin";
        }
        else
        {
            return "welcomePrimefaces";    
        }
    }
    
    public String lol2(){
        return "index";
    }
    public String monprofil(){
        return "monprofil";
    }
    public String logout(){
        username="";
        password="";
        nom="";
        image="";
        statut="";
        return "index";
    }
}