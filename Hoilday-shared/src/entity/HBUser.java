/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
//package fit5042.tutex.repository.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 *
 * @author CICIJ
 */
@Entity
@Table(name = "HBUser")

@NamedQueries({
    @NamedQuery(name = HBUser.GET_ALL_QUERY_NAME, query = "SELECT u FROM HBUser u")})
   

public class HBUser implements Serializable{
    public static final String GET_ALL_QUERY_NAME = "HBUser.getAll";
     public static final String findUser = "HBUser.findUser";
       public static final String findEmail = "HBUser.findEmail";
         public static final String findPostcode = "HBUser.findPostcode";
    private int Id;    
    private String lastName;
    private String firstName;
    private String email;
    private String password;    
    private String type; 
    private String streetAddress;
    private String city;
    private String country;
    private String postcode;
    private String phoneNumber;
    private List<HBTransaction>  transactions;

    public HBUser() {
       
         
 }
    public HBUser(String city,String country,String email,String firstName,String lastName,String password,String phoneNumber,String  postcode,String  streetAddress,String type)
        {
            //this.Id = Id;
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.type = type;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        //this.transactions= new HashList<>();
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + ", password=" + password + ", type=" + type + ", streetAddress=" + streetAddress + ", city=" + city + ", country=" + country + ", postcode=" + postcode + ", phoneNumber=" + phoneNumber + '}';
    }

    
    @OneToMany(mappedBy = "user" ,cascade=CascadeType.MERGE,fetch=EAGER)
    public List<HBTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<HBTransaction> transactions) {
        this.transactions = transactions;
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
