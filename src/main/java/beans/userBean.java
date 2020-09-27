package beans;

import model.User;
import org.primefaces.model.StreamedContent;
import service.UserService;
import utils.SaveLoadFiles;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class userBean {
    private StreamedContent filed;
    private String name;
    private User user;

    @Inject
    UserService userService;
    @PostConstruct
    public void init(){

        name= (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("name");
        if(name.equals(null)){
            name="Toda via no tiene una foto asignada por favor contacte al vendedor";
        }else{
            user = userService.getSingleUser(name);
            if(user==null){

            }
        }
    }

    public StreamedContent donwload(String name){
        filed = SaveLoadFiles.loadFile(name);
        return filed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
