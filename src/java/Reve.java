
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
import javax.faces.context.FacesContext;
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
    private float cout = 0;
    private String validation = "";
    private String desc = "";
    private String image = "";

    public Reve(String nomReve, String desc, String validation, String image) {
        this.nomReve=nomReve;
        this.desc=desc;
        this.validation=validation;
        this.image=image;
    }
    

    
    public String getNomReve() {
        return nomReve;
    }

    public void setNomReve(String nomReve) {
        this.nomReve = nomReve;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
   
    

}
