import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
@SessionScoped
public class FileUploadView {
     
    private UploadedFile file;
    
    private String destination = "C:/Users/Kevin_2/Documents/NetBeansProjects/Dream-Factory2/web/Resources/";
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            System.out.println("Dans l'upload");
            copyFile();
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
        public void copyFile() { 
        try {
            System.out.println("Dans le copy");
            InputStream in=file.getInputstream();
            try ( // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + file.getFileName()))) {
                int read;
                byte[] bytes = new byte[1024];
                
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
            }

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}