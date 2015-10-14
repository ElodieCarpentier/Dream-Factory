
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
@ManagedBean
public class MenuView {
     
    public String utilisateur() {
        return "user";
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
    
    public String creationreve(){
        return "creationreve";
    }
    
    public String creationreve2(){
        return "creationreve2";
    }
    
    public String validationreve(){
        return "validationreve";
    }
    
    public String validationreve2(){
        return "validationreve2";
    }
    
     public String risque(){
        return "risque";
    }
     
     public String risque2(){
        return "risque2";
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
