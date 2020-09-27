package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@RequestScoped
@Named
public class IndexBean {

    private String name;
    private String password;

    public String valitation(){
        if(name.equals("gonzalo")&&password.equals("gonzalo")){
            FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put("name",name);
            return "admin" + "?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("name",name);
            return "users" + "?faces-redirect=true";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
