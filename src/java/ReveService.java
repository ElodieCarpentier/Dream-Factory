
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
    public int finance;
    
    
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
                
                list.add(new Reve(nom,desc,image,"",0));
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
                
                list.add(new Reve(nom,desc,image,"",0));
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
                
                list.add(new Reve(nom,desc,image,"",0));
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
                
                list.add(new Reve(nom,desc,image,risque,0));
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
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE, COUT FROM reve where VALIDATION = ?");
            ps.setString(1, "en finance");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                finance=rs.getInt("COUT");
                
                list.add(new Reve(nom,desc,image,risque,finance));
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
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE, COUT FROM reve where VALIDATION = ?");
            ps.setString(1, "valide");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                finance=rs.getInt("COUT");
                
                list.add(new Reve(nom,desc,image,risque,finance));
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
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE, COUT FROM reve where VALIDATION = ?");
            ps.setString(1, "proto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                finance=rs.getInt("COUT");
                
                list.add(new Reve(nom,desc,image,risque,finance));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
    
    public List<Reve> createListFini()throws SQLException, ClassNotFoundException{
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
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION, IMAGE_REVE, RISQUE_REVE, COUT FROM reve where VALIDATION = ?");
            ps.setString(1, "ok");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                image="Resources/"+rs.getString("IMAGE_REVE");
                risque=rs.getString("RISQUE_REVE");
                finance=rs.getInt("COUT");
                
                list.add(new Reve(nom,desc,image,risque,finance));
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
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le rève est envoyé pour acceptation du prototype par le directeur","");
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
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Les rêve à été refusé avec succes ","");
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
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le risque a bien été enregistrés avec succès ","");
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
    public void envoievalidation(String nomdureve){
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
            String sql= "UPDATE reve SET COUT='"+finance+"', VALIDATION='valide' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where COUT=? and VALIDATION=?");
            ps2.setInt(1,finance);
            ps2.setString(2,"valide");
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le rêve à été envoyé au département de validation ","");
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
    public void ajoutcout(String nomdureve,float money){
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
            String sql= "UPDATE reve SET COUT="+money+" WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where COUT="+money+"");
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le cout a bien été enregistrés avec succès ","");
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
     public void acceptation(String nomdureve){
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
            String sql= "UPDATE reve SET VALIDATION='ok' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where VALIDATION='ok' and IDREVE=?");
            ps2.setString(1,nomdureve);
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le prototype est approuvé et envoyé à l'usine ","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, le prototype n'a pas été envoyé","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        
    }
     public void refus(String nomdureve){
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
            String sql= "UPDATE reve SET VALIDATION='refusé' WHERE IDREVE='"+nomdureve+"'";
            ps.executeUpdate(sql);
            ps2= con.prepareStatement("Select * from reve where VALIDATION='refusé' and IDREVE=?");
            ps2.setString(1,nomdureve);
            ResultSet rs2 = ps2.executeQuery();
            
             if (rs2.next()) // found
            {
                 message2 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Le prototype à été refusé","");
             }
             else{
                 message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur, le prototype n'a pas pu être refusé","");   
             }
             }
           
           catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
          
             }
        context.addMessage(null, message2);
        
    }
    private void reinitialisation(){
        this.risque="";
        this.nom="";
        
    }
}
