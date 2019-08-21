package mbeans;


import entity.HBTransaction;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import entity.HBUser;
import java.io.IOException;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
//import javax.jPAUserAndTransactionRepositoryImpl.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolationException;
import repository.Repository;

@ManagedBean
@Named(value = "userBean")
// TODO You can change to @ApplicationScoped and see the difference
@RequestScoped
//@ApplicationScoped
public class userBean implements Serializable {

    @EJB
    private Repository jPAUserAndTransactionRepositoryImpl;

private TransactionBean transactionBean;
private  ArrayList<String> searchList;
private  ArrayList<String> typeList;
    private int Id; 
    private String city;
    private String country;
    private String email;
    private String lastName;
    private String firstName;
    
    private String password;    
    private String phoneNumber;
    
     private String postcode;
    private String streetAddress;
    private String type; 
   
    
    private HBUser newUser;
    private List<HBTransaction> transactions;
    private String searchType;
    private String searchContent;

       public userBean() throws Exception {
//       
         searchList = new ArrayList<>();
         searchList.add("Id");
         searchList.add("First Name");
         searchList.add("Last Name");
         searchList.add("Email");
         searchList.add("Type");
         typeList = new ArrayList<>();
         typeList.add("admin");
         typeList.add("public");
       
    }

    public ArrayList<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(ArrayList<String> typeList) {
        this.typeList = typeList;
    }

    public ArrayList<String> getSearchList() {
        return searchList;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public void setSearchList(ArrayList<String> searchList) {
        this.searchList = searchList;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
      

   
        public List<HBTransaction> getTransactions() {
        return transactions;
    }
//(List<HBTransaction> transactions)
    public void setTransactions() throws Exception {
        this.transactions = jPAUserAndTransactionRepositoryImpl.searchTransactionByUserId(Id);
    }
    
    public int getId()  {
  return Id;
    }

    // Get user account(email)
    public String Text() {
    String p1 =  FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    
    return p1;
}
   
    public void setId(int Id) throws Exception {
        this.Id=Id;
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
        this.password = SHA(password);
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

 
   
     public HBUser addUser() throws Exception{
        
       
        HBUser user = new HBUser(city,country,email,firstName,lastName,password,phoneNumber,postcode,streetAddress,type);

        try {
            jPAUserAndTransactionRepositoryImpl.addUser(user);
            //this.displayAlltransactions();
            //this.transactionController.clearInput();
        } 
        catch (ConstraintViolationException  ex) {
           // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
           throw ex;
           
        } 
       return user;
    }

     private String SHA(String strText) {
        String strResult = null;

        
        if (strText != null && strText.length() > 0) {
            try {
               
                MessageDigest messageDigest = MessageDigest
                        .getInstance("SHA-256");
                
                messageDigest.update(strText.getBytes());
               
                byte byteBuffer[] = messageDigest.digest();

               
                StringBuffer strHexString = new StringBuffer();
               
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }

     
          public HBUser editUser() throws Exception{
        
        HBUser user = new HBUser(city,country,email,firstName,lastName,password,phoneNumber,postcode,streetAddress,type);

        try {
            jPAUserAndTransactionRepositoryImpl.editUser(user);
            //this.displayAlltransactions();
            //this.transactionController.clearInput();
        } 
        catch (ConstraintViolationException  ex) {
           // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
           throw ex;
           
        } 
       return user;
    }
          
     public void removeUser(){
         int id=getId();
        try {
            jPAUserAndTransactionRepositoryImpl.removeUser(Id);
            
        } catch (Exception ex) {
           // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
           System.out.println("Failed to remove in userBean:");
        } 
      
     }
    
      public List<HBUser> searchUser() throws Exception {  
           List<HBUser> result=new ArrayList();
          
          if( searchType.equals("Email")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchUserByEmail(searchContent);

             }
           if( searchType.equals("Last Name")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchUserByLastName(searchContent);

             }
           if( searchType.equals("First Name")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchUserByFirstName(searchContent);

             }
            if( searchType.equals("Type")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchUserByType(searchContent);

             }
             if( searchType.equals("Id")){
                int c=Integer.parseInt(searchContent);
                result.add(jPAUserAndTransactionRepositoryImpl.searchUserById(c));

             }
           return result;
      }
      
      public List<HBUser> searchUserByComination() throws Exception {
          List<HBUser> result=null;
          if(lastName!=null&&firstName!=null&&type!=null){
          result = jPAUserAndTransactionRepositoryImpl.searchUserByComination(lastName,firstName,type);
          }
          if(firstName!=null&&type!=null){
          result = jPAUserAndTransactionRepositoryImpl.searchUserByFirstNameAndType(firstName,type);
          }
          if(lastName!=null&&type!=null){
          result = jPAUserAndTransactionRepositoryImpl.searchUserByLastNameAndType(lastName, type);
          }
          if(lastName!=null&&firstName!=null){
              result = jPAUserAndTransactionRepositoryImpl.searchUserByLastNameAndFirstName(lastName, firstName);
          }
         return result;
      }
      
     public HBUser searchUserByID() throws Exception {  
         Id = Integer.valueOf(FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("Id"));
        HBUser result = jPAUserAndTransactionRepositoryImpl.searchUserById(Id);

         return result;
    }
     
    public HBUser searchUserByEmail() throws Exception {
        String email=this.Text();
        HBUser result = jPAUserAndTransactionRepositoryImpl.searchUserByEmail(email).get(0);
//        transactionBean.userId=result.getId();
         return result;
    }
    
     
    public List<HBUser> searchUserByLastName() throws Exception {
        //String lastName=this.getLastName();
        List<HBUser> result = jPAUserAndTransactionRepositoryImpl.searchUserByLastName(lastName);
        //property.getTags().size();
        //return "index.xhtml";
         return result;
    }
   
    
     public List<HBUser> getAllUsers() throws Exception {
         
                
                 List<HBUser> userList = jPAUserAndTransactionRepositoryImpl.getAllUsers();
            return userList;
   
    }
     //used by admin
       public List<HBTransaction>  searchTransactionByUserId() throws Exception {
        //userId=searchUserByEmail().getId();
        List<HBTransaction> result= jPAUserAndTransactionRepositoryImpl.searchTransactionByUserId(Id);
        return result;
    }
       public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("../index_1.xhtml");
        } catch (IOException e) {
        }
    }
}
