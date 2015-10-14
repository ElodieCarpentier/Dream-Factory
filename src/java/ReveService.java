
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
                    "select IDREVE, DESCRIPTION_REVE FROM reve where VALIDATION= ?");
            ps.setString(1, "en attente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                list.add(new Reve(nom,desc,""));
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
                    "select IDREVE, DESCRIPTION_REVE, VALIDATION FROM reve where VALIDATION = ? or VALIDATION = ? order by VALIDATION");
            ps.setString(1, "oui");
            ps.setString(2, "non");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                
                nom=rs.getString("IDREVE");
                desc=rs.getString("DESCRIPTION_REVE");
                validation=rs.getString("VALIDATION");
                if (validation.equals("oui")){
                    validation="Resources/accepter.jpg";
                }
                else
                {
                    validation="Resources/Croix-rouge.png";
                }
                list.add(new Reve(nom,desc,validation));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
        
}