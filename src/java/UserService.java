
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin_2
 */

@ManagedBean(name="dtBasicView")
@ViewScoped

public class UserService {
   
    public String image;
    public String nom;
    public String statut;
    
        public List<User> createList()throws SQLException, ClassNotFoundException{
        List<User> list= new ArrayList<User>();
        Connection con = null;
        PreparedStatement ps = null;
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select NOM_USER, STATUT, IMAGE FROM user");
 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                image="Resources/"+rs.getString("IMAGE");
                statut=rs.getString("STATUT");
                nom=rs.getString("NOM_USER");
                list.add(new User(nom, statut,image));
            }
            System.out.println(list);
             } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
        return list;
    }
}
