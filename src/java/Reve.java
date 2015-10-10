
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
import javax.faces.event.ActionEvent;
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
@ManagedBean
@SessionScoped
public class Reve {

    private String nomReve ="";
    private int niveau = 0;
    private float cout = 0;
    private String validation = "";
    private String desc = "";
    private List<String> reve = new ArrayList<String>();
    
    public String getNomReve() {
        return nomReve;
    }

    public void setNomReve(String nomReve) {
        this.nomReve = nomReve;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getReve() {
       return reve;
    }

    public void setReve(List<String> reve) {
        this.reve = reve;
    }
    public void affichereve() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        /*reve=new ArrayList<String>();*/
        Class.forName( "com.mysql.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        try {
            con = DriverManager.getConnection(url, login, passwd);
            ps = con.prepareStatement(
                    "select IDREVE, NIVEAU, COUT, VALIDATION, DESCRIPTION_REVE FROM reve");
 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                reve.add(rs.getString("IDREVE"));
            }
            System.out.println(reve);
            
        } 
        catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            
        }
    
    
    
}
}
