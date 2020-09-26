package beans;

import model.User;
import org.h2.util.IOUtils;
import org.primefaces.model.file.UploadedFile;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class UserBean {

    private User user;
    private List<User> userList;

    private String name;

    private UploadedFile file;

    @Inject
    UserService userService;

    @PostConstruct
    public void init() {
        userList = userService.getAllUsers();
    }

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

    public void upload() {
        if (file != null && name != null) {
            User user = new User();
            user.setName(name);
            userService.saveUser(user);
            FacesMessage message = new FacesMessage("Successful", file.getFileName()
                    + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
