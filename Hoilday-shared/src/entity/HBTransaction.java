/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

//package fit5042.tutex.repository.entities;

//import fit5042.tutex.repository.entities.Public;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author CICIJ
 */
@Entity
@Table(name= "HBTransaction") //has mistakes here before as named(value=..)
@NamedQueries({@NamedQuery(name = HBTransaction.GET_ALL_QUERY_NAME, query = "SELECT p FROM HBTransaction p")})

public class HBTransaction implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "HBTransaction.getAll";
    
    private String type;
    private int Id;    
    private String name;
    private String description;
    private HBUser user;
    private int userId; 
    private String date;
    private int amount;
    private int price;
    
    public HBTransaction() {
      
        
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = amount*200;
    }
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HBTransaction{" + "type=" + type + ", Id=" + Id + ", name=" + name + ", description=" + description + ", userId=" + userId + '}';
    }


    
    public HBTransaction(String name, String type, String description,int userId,String date,int amount,int price) {
        this.Id = Id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.userId=userId;
        this.date=date;
        this.amount=amount;
        this.price=price;
       
    }

    @ManyToOne(cascade=CascadeType.MERGE,fetch=EAGER)
    public HBUser getUser() {
        return user;
    }

    public void setUser(HBUser user) {
        this.user = user;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
      //@ManyToOne
    public String getType() {
        return type;
    }
    
      public void setType(String type) {
        this.type = type;
    }

   
}
