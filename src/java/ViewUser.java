import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 


public class ViewUser implements Serializable {
     
    private List<User> users;
     
    @ManagedProperty("#{userService}")
    private UserService service ;
 
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    /*
    @PostConstruct        
    public void init(){
        users = service.createList();
    }
     */
    public List<User> getUsers() {
        return users;
    }
 
    public void setService(UserService service) {
        this.service = service;
    }
}
