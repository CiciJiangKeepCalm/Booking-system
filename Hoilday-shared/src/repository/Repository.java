/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import entity.HBUser;
import entity.HBTransaction;
import entity.Type;
import java.util.List;
import java.util.Set;
//
import javax.ejb.Remote;


/**
 *
 * @author CICIJ
 */
@Remote
public interface Repository {
    
   
    public void addUser(HBUser User) throws Exception ;
    
    
    public HBUser searchUserById(int id) throws Exception;
   
   // public List<HBUser> searchUserByComination(int id,String lastName,String firstName,String postcode,String email) throws Exception;
     public List<HBUser> searchUserByLastName(String lastName) throws Exception;
     public List<HBUser> searchUserByFirstName(String firstName) throws Exception;
   
    public List<HBUser> searchUserByEmail(String email) throws Exception;
   public List<HBUser> searchUserByType(String type) throws Exception ;
   
    public List<HBUser> getAllUsers() throws Exception ;


    public void removeUser(int userId) throws Exception;

    public void removeTransaction(int transactionId) throws Exception;
   
    public void removeType(int typeId) throws Exception;
    public Type searchTypeById(int typeId) throws Exception;
    public void editUser(HBUser user) throws Exception ;
    
    //////
    public void addTransaction(HBTransaction transaction) throws Exception ;
    
     public List<HBUser> searchTransactionByComination(int id,String name,String type,String decription,int userId) throws Exception;
      public HBTransaction searchTransactionById(int id)throws Exception;

     public List<HBTransaction> searchTransactionByType(String type,int userId) throws Exception;
     public List<HBTransaction> searchTransactionByName(String name,int userId)throws Exception;
    public List<HBTransaction> searchTransactionByUserId(int userId) throws Exception;
   
    public List<HBTransaction> getAllTransactions() throws Exception ;
    
    public List<Type> getAllTypes() throws Exception;


    public List<HBTransaction> searchTransactionByTypeAdmin(String type) throws Exception;

    public List<HBTransaction> searchTransactionByNameAdmin(String name) throws Exception;

    public List<HBTransaction> searchTransactionByDescription(String description, int userId) throws Exception;

    public List<HBTransaction> searchTransactionByDescriptionAdmin(String description) throws Exception;

    public List<HBTransaction> searchTransactionByIdUser(int id, int userId) throws Exception;


    public void addType(Type type) throws Exception;

    //public List<HBUser> searchUserByComination(String lastName, String firstName, String type, String email) throws Exception;

    public List<HBUser> searchUserByComination(String lastName, String firstName, String type) throws Exception;

    public List<HBUser> searchUserByFirstNameAndType(String firstName, String type) throws Exception;

    public List<HBUser> searchUserByLastNameAndType(String lastName, String type) throws Exception;

    public List<HBUser> searchUserByLastNameAndFirstName(String lastName, String firstName) throws Exception;

}
