
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    private String nomreve;
    
    private String descriptionreve;
        
    private String image;
    
    private String statut;
    
    private String validation="en risque";
    
    private String imageUser;
    
    private String nomUser;
    
    private String statutUser;
    

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getValidation() {
        return validation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
   

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

    public String getNomreve() {
        return nomreve;
    }

    public void setNomreve(String nomreve) {
        this.nomreve = nomreve;
    }


    public String getDescriptionreve() {
        return descriptionreve;
    }

    public void setDescriptionreve(String descriptionreve) {
        this.descriptionreve = descriptionreve;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getStatutUser() {
        return statutUser;
    }

    public void setStatutUser(String statutUser) {
        this.statutUser = statutUser;
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
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue", nom); 
            }
            else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Identifiants erronés");
            }
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        if (loggedIn){
            System.out.println("Loger in");
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
    public String monprofil(){
        return "monprofil";
    }
    
    public String profil(String image, String nom, String statut){
        this.imageUser=image;
        this.nomUser=nom;
        this.statutUser=statut;
        return "profil";
    }
    
    public void logout(){
        username="";
        password="";
        nom="";
        image="";
        statut="";
    }
    public void insertionReve()throws SQLException, ClassNotFoundException{
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message2 = null;
        Connection con = null;
        Statement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps2= con.prepareStatement("Select * from reve where IDREVE=?");
            ps2.setString(1,nomreve);
            
            ResultSet rs2= ps2.executeQuery();

             if (rs2.next()) // found
             {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Il existe déjà un rêve avec ce nom","");
             }
             else{
            
            ps = con.createStatement();
            String sql= "INSERT into reve (IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE) values ('"+ nomreve +"','" + descriptionreve +"','"+ validation +"','pasdispo.png')";
            ps.executeUpdate(sql);

            
            ps3= con.prepareStatement("Select * from reve where IDREVE=?");
            ps3.setString(1,nomreve);
            ResultSet rs3 = ps3.executeQuery();
            
             if (rs3.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le rêve a été enregistré avec succès","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, le reve n'a pas été enregistré","");   
             }
             }
             
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());   
        }
        context.addMessage(null, message2);
        reinitialisation();
        
    }

    private void reinitialisation(){
        this.nomreve="";
        this.descriptionreve="";
        this.nomreve="";
    }
    
    


}
