package beans;

import model.User;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import utils.SaveLoadFiles;

@RequestScoped
@Named
public class AdminBean {

    private User user;
    private List<User> userList;

    private String name;

    private UploadedFile file;

    private StreamedContent filed;

    @Inject
    UserService userService;

    @PostConstruct
    public void init() {
        userList = userService.getAllUsers();
        cleanData();
    }

    //FUNTIONS
    public void cleanData(){
        name=null;
        file=null;
    }


    public void upload() throws IOException {
        if (file != null && name != null) {
            User user = new User();
            user.setName(name);
            userService.saveUser(user);

            SaveLoadFiles.saveFile(file,"lol.png");

            FacesMessage message = new FacesMessage("Successful", file.getFileName()
                    + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            cleanData();
        }
    }
    public StreamedContent donwload(String name){
        filed = SaveLoadFiles.loadFile(name);
        return filed;
    }
    public AdminBean() {

    }


    //GETTERS SETTERS

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }


    public StreamedContent getFiled() {
        return filed;
    }

    public void setFiled(StreamedContent filed) {
        this.filed = filed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
