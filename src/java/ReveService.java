
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private void reinitialisation(){
        this.risque="";
        this.nom="";
        
    }
}