package mbeans;


import entity.HBTransaction;
import entity.Type;
import javax.inject.Named;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import repository.Repository;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.validation.ConstraintViolationException;
/**
 *
 * @author Jian
 */
@ManagedBean
@Named(value = "typeBean")

@RequestScoped
public class typeBean implements Serializable {

    @EJB
    private Repository jPAUserAndTransactionRepositoryImpl;

    private Type type;
    private int Id;
    private String name;
    private List<Type> typeList;



    public typeBean() throws Exception {
        //typeList= this.getAllTypes();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
       public List<Type> getAllTypes() throws Exception {
    
                 List<Type> typeList = jPAUserAndTransactionRepositoryImpl.getAllTypes();
                  return typeList;
          
    }
      
           public Type addType() throws Exception {
          type = new Type(Id,name);
        try {
            jPAUserAndTransactionRepositoryImpl.addType(type);

        } catch (ConstraintViolationException ex) {
            // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
            throw ex;
        }
        return type;
    }
         public void removeType(){
         int id=getId();
        try {
            jPAUserAndTransactionRepositoryImpl.removeType(id);
            
        } catch (Exception ex) {
           // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
           System.out.println("Failed to remove in typeBean:");
        } 
      
     }


   
    
}
