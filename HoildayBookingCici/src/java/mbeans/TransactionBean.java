package mbeans;


import entity.HBTransaction;
import entity.HBUser;

import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import repository.Repository;

/**
 *
 * @author Jian
 */
@ManagedBean
@Named(value = "transactionBean")
// TODO You can change to @ApplicationScoped and see the difference
@RequestScoped

public class TransactionBean implements Serializable {

    @EJB
    private Repository jPAUserAndTransactionRepositoryImpl;
    private  ArrayList<String> searchList;
    private String type;
    private HBTransaction tran;
    private int Id;
    private String name;

    private String description;
    private HBUser user;
    private int userId;
    private  ArrayList<String> dateList;
    private  ArrayList amountList;
    private String date;
    private int amount;
    private int price;
       private String searchType;
    private String searchContent;

        public TransactionBean()  {
          dateList = new ArrayList<>();
         dateList.add("October 11");
         dateList.add("October 12");
         dateList.add("October 13");
         dateList.add("October 15");
         dateList.add("October 17");
         dateList.add("October 18");
         dateList.add("October 19");
         dateList.add("October 20");
         
         amountList=new ArrayList<>();
         amountList.add(1);
         amountList.add(2);
          amountList.add(3);
         amountList.add(4);
         
         searchList = new ArrayList<>();
         searchList.add("Id");
         searchList.add("Name");
         searchList.add("Type");
         searchList.add("Description");
    }

    public ArrayList<String> getSearchList() {
        return searchList;
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

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

        
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

     
    public ArrayList<String> getDateList() {
        return dateList;
    }

    public void setDateList(ArrayList<String> dateList) {
        this.dateList = dateList;
    }

    public ArrayList getAmountList() {
        return amountList;
    }

    public void setAmountList(ArrayList amountList) {
        this.amountList = amountList;
    }
        
        
    public int getUserId() {
        return user.getId();
    }

    public void setUserId(){
        this.userId = user.getId();
    }
// by admin
 public List<HBTransaction> searchTransaction() throws Exception {  
          //searchType=this.getSearchType();
           List<HBTransaction> result=new ArrayList();
          if( searchType.equals("Type")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByTypeAdmin(searchContent);

             }
          
           if( searchType.equals("Name")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByNameAdmin(searchContent);

             }
            if( searchType.equals("Description")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByDescriptionAdmin(searchContent);

             }
             if( searchType.equals("Id")){
                int c=Integer.parseInt(searchContent);
                result.add(jPAUserAndTransactionRepositoryImpl.searchTransactionById(c));

             }
           return result;
      }
 
 // by public user
 public List<HBTransaction> searchTransactionUser() throws Exception {  
          //searchType=this.getSearchType();
           List<HBTransaction> result=new ArrayList();
          if( searchType.equals("Type")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByType(searchContent,userId);
             }
          
           if( searchType.equals("Name")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByName(searchContent,userId);

             }
            if( searchType.equals("Description")){
          
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByDescription(searchContent,userId);

             }
             if( searchType.equals("Id")){
                int c=Integer.parseInt(searchContent);
                result=jPAUserAndTransactionRepositoryImpl.searchTransactionByIdUser(c,userId);

             }
           return result;
      }
 


    public HBUser getUser() throws Exception {

        return searchUserByEmail();
    }
  
    public void setUser(HBUser user) throws Exception {
        this.user = user;
    }

public String test() {
      HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();  
      name=request.getParameter("name"); 
      
      System.out.print(name);     
          
      return null;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HBTransaction getTransaction() {
        return tran;
    }

    public void setTransaction(HBTransaction tran) {
        this.tran = tran;
    }

    public HBTransaction searchTransactionByAdmin() throws Exception {
       Id = Integer.valueOf(FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("Id"));

        HBTransaction transaction = jPAUserAndTransactionRepositoryImpl.searchTransactionById(Id);

        return transaction;
    }
    
    // for user search
    public HBTransaction searchTransactionById() throws Exception {
     Id = Integer.valueOf(FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("Id"));

        HBTransaction transaction = jPAUserAndTransactionRepositoryImpl.searchTransactionById(Id);

        return transaction;
    }
    
            
    
    public List<HBTransaction> searchTransactionByType() throws Exception {

        List<HBTransaction> result = jPAUserAndTransactionRepositoryImpl.searchTransactionByType(type,userId);
       

        return result;
    }

    public List<HBTransaction> searchTransactionByName() throws Exception {

        List<HBTransaction> result = jPAUserAndTransactionRepositoryImpl.searchTransactionByName(name,userId);

        return result;
    }

   
// used by admin
        public List<HBTransaction>  searchTransactionByUserIdAdmin() throws Exception {
        Id = Integer.valueOf(FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestParameterMap()
            .get("Id"));
        List<HBTransaction> result= jPAUserAndTransactionRepositoryImpl.searchTransactionByUserId(Id);
        return result;
    }
    
  // used by public user
        public List<HBTransaction>  searchTransactionByUserId() throws Exception {
        userId=searchUserByEmail().getId();
        List<HBTransaction> result= jPAUserAndTransactionRepositoryImpl.searchTransactionByUserId(userId);
        return result;
    }

        public HBTransaction saveTransaction() throws Exception {
          
            userId=searchUserByEmail().getId();
            
           price=200*amount;
             HBTransaction tran = new HBTransaction(name,type, description,userId,date,amount,price);
             return tran;
        }
        
           public HBTransaction addTransaction(HBTransaction tran) throws Exception {
   
        try {
            jPAUserAndTransactionRepositoryImpl.addTransaction(tran);

        } catch (ConstraintViolationException ex) {
            // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
            throw ex;
        }
        return tran;
    }
           
           
           
            public String Text() {
    String p1 =  FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    
    return p1;
}
            
   
            public HBUser searchUserByEmail() throws Exception {
        String email=this.Text();
        HBUser result = jPAUserAndTransactionRepositoryImpl.searchUserByEmail(email).get(0);
//        transactionBean.userId=result.getId();
         return result;
    }
            
 

         public void removeTransaction(){
         int id=getId();
        try {
            jPAUserAndTransactionRepositoryImpl.removeTransaction(id);
            //this.displayAlltransactions();
            //this.transactionController.clearInput();
        } catch (Exception ex) {
           // this.transactionController.displayMessageInDialog("Failed to add property: " + ex.getMessage());
           System.out.println("Failed to remove in tranBean:");
        } 
      
     }
    
           public List<HBTransaction> getAllTransactions() throws Exception {
         
                 List<HBTransaction> tList = jPAUserAndTransactionRepositoryImpl.getAllTransactions();
            return tList;
   
    }
     
}
