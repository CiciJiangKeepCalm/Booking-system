package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Eddie
 */
@Entity
@Table(name = "Type")
@NamedQueries({@NamedQuery(name = Type.GET_ALL_QUERY_NAME, query = "SELECT t FROM Type t")})
public class Type implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Type.getAll";
    
     private int Id; 
    private String name;
    private Set<HBTransaction>  transactions;


    public Type() {
    }

    public Type(int Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
  //@OneToMany(mappedBy = "type" )
    public Set<HBTransaction> getTransactions() {
        return transactions;
    }

     public void setTransactions(Set<HBTransaction> transactions) {
        this.transactions = transactions;
    }

}
