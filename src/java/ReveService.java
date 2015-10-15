
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin_2
 */

@ManagedBean(name="dtReveView")
@ViewScoped
@SessionScoped

public class ReveService {
   
    public String nom;
    public String desc;
    public String validation;
    public String image;
    public String risque;
    
        public List<Reve> createList()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, IMAGE_REVE FROM reve where VALIDATION= ?");
            ps.setString(1, "en risque");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                list.add(new Reve(nom,desc,image,""));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
        public List<Reve> createListaccepte()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "oui");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                list.add(new Reve(nom,desc,image,""));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
        
         public List<Reve> createListrefuse()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "non");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                list.add(new Reve(nom,desc,image,""));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
         
    public List<Reve> createListRisque()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "en risque");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                list.add(new Reve(nom,desc,image,risque));
                reinitialisation();
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }     
        
    public List<Reve> createListFinance()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "en finance");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                
                list.add(new Reve(nom,desc,image,risque));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }     
    
    public List<Reve> createListValide()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "valide");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                
                list.add(new Reve(nom,desc,image,risque));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }   
    
    public List<Reve> createListProto()throws SQLException, ClassNotFoundException{
        List<Reve> list= new ArrayList<Reve>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE FROM reve where VALIDATION = ?");
            ps.setString(1, "proto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                
                list.add(new Reve(nom,desc,image,risque));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
    public void valider(String nomdureve){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message2 = null;
        Connection con = null;
        Statement ps = null;
        PreparedStatement ps2= null;
        try
        {
        Class.forName( "com.mysql.jdbc.Driver" );
        }
         catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
             }
            
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.createStatement();
            String sql= "UPDATE reve SET VALIDATION='proto' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where VALIDATION='proto' and IDREVE=?");
            ps2.setString(1,nomdureve);
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Les risques ont été enregistrés avec succès ","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, les informations n'ont pas été enregistrées","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        
    }
     public void nonvalider(String nomdureve){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message2 = null;
        Connection con = null;
        Statement ps = null;
        PreparedStatement ps2= null;
        try
        {
        Class.forName( "com.mysql.jdbc.Driver" );
        }
         catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
             }
            
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.createStatement();
            String sql= "UPDATE reve SET VALIDATION='non' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where VALIDATION='non' and IDREVE=?");
            ps2.setString(1,nomdureve);
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Les risques ont été enregistrés avec succès ","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, les informations n'ont pas été enregistrées","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        
    }
    public void envoiefinance(String nomdureve){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message2 = null;
        Connection con = null;
        Statement ps = null;
        PreparedStatement ps2= null;
        try
        {
        Class.forName( "com.mysql.jdbc.Driver" );
        }
         catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
             }
            
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.createStatement();
            String sql= "UPDATE reve SET RISQUE_REVE='"+risque+"', VALIDATION='en finance' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where RISQUE_REVE=? and VALIDATION=?");
            ps2.setString(1,risque);
            ps2.setString(2,"en finance");
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le rêve à été envoyé au département des finances ","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, le rêve n'a pas été envoyé","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        
    }
    public void ajoutrisque(String nomdureve,String risquereve){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message2 = null;
        Connection con = null;
        Statement ps = null;
        PreparedStatement ps2= null;
         System.out.println(risquereve);
         System.out.println("Nom du reve :"+nomdureve+"");
        try
        {
        Class.forName( "com.mysql.jdbc.Driver" );
        }
         catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
             }
            
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.createStatement();
            String sql= "UPDATE reve SET RISQUE_REVE='"+risquereve+"' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where RISQUE_REVE=?");
            ps2.setString(1,risquereve);
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Les risques ont été enregistrés avec succès ","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, les informations n'ont pas été enregistrées","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        reinitialisation();
        
    }
    private void reinitialisation(){
        this.risque="";
        this.nom="";
        
    }
}
