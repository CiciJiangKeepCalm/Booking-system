/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.HBTransaction;
import entity.HBUser;
import entity.Type;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import repository.Repository;


/**
 *
 * @author CICIJ
 */
@Stateless
public class JPAUserAndTransactionRepositoryImpl implements Repository{
    @PersistenceContext
        //(unitName="HoildayBookingCici-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addUser(HBUser user) throws Exception {
        //entityManager.getTransaction().begin();
        entityManager.persist(user);
       // entityManager.getTransaction().commit();
    }

    @Override
    public void editUser(HBUser user) throws Exception {      
        entityManager.merge(user);
    }  
    
    @Override
    public HBUser searchUserById(int id) throws Exception {
        HBUser user = entityManager.find(HBUser.class, id);
        //property.getTags().size();
        return user;
    }

    @Override
    public List<HBUser> searchUserByComination(String lastName,String firstName,String type) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
   
        Path<String> two = u.get("lastName");
        Path<String> three= u.get("firstName");
        Path<String> four = u.get("type");
           
        Predicate p = qb.and(qb.equal(two, lastName),qb.equal(three,firstName),qb.equal(four,type)); 
         List<HBUser>result =entityManager.createQuery(c.where(p)).getResultList(); 
        //Predicate condition = qb.equal(u.get("lastName"), lastName);
        //,String type,String email
        
        return result;
    }
    @Override
    public List<HBUser> searchUserByLastNameAndFirstName(String lastName,String firstName) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
   
        Path<String> two = u.get("lastName");
        Path<String> three= u.get("firstName");
        
           
        Predicate p = qb.and(qb.equal(two, lastName),qb.equal(three,firstName)); 
         List<HBUser>result =entityManager.createQuery(c.where(p)).getResultList(); 
        //Predicate condition = qb.equal(u.get("lastName"), lastName);
        //,String type,String email
        
        return result;
    }
    
     public List<HBUser> searchUserByLastNameAndType(String lastName,String type) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
   
        Path<String> two = u.get("lastName");
        Path<String> three= u.get("type");
        
           
        Predicate p = qb.and(qb.equal(two, lastName),qb.equal(three,type)); 
         List<HBUser>result =entityManager.createQuery(c.where(p)).getResultList(); 
        //Predicate condition = qb.equal(u.get("lastName"), lastName);
        //,String type,String email
        
        return result;
    }
      public List<HBUser> searchUserByFirstNameAndType(String firstName,String type) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
   
        Path<String> two = u.get("firstName");
        Path<String> three= u.get("type");
        
           
        Predicate p = qb.and(qb.equal(two, firstName),qb.equal(three,type)); 
         List<HBUser>result =entityManager.createQuery(c.where(p)).getResultList(); 
        //Predicate condition = qb.equal(u.get("lastName"), lastName);
        //,String type,String email
        
        return result;
    }
      
    
    @Override
    public List<HBUser> searchUserByLastName(String lastName) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
        Predicate condition = qb.equal(u.get("lastName"), lastName);
        c.where(condition);
        TypedQuery<HBUser> q = entityManager.createQuery(c);
        List<HBUser> result = q.getResultList();
        
        return result;
    }
    
    
    @Override
    public List<HBUser> searchUserByFirstName(String firstName) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
        Predicate condition = qb.equal(u.get("firstName"), firstName);
        c.where(condition);
        TypedQuery<HBUser> q = entityManager.createQuery(c);
        List<HBUser> result = q.getResultList();
        
        return result;
       
    }
    
 
        @Override
    public List<HBUser> searchUserByEmail(String email) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
        Predicate condition = qb.equal(u.get("email"), email);
        c.where(condition);
        TypedQuery<HBUser> q = entityManager.createQuery(c);
        List<HBUser> result = q.getResultList();
        
        return result;
       
    }
    
    @Override
    public List<HBUser> searchUserByType(String type) throws Exception {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
        Predicate condition = qb.equal(u.get("type"), type);
        c.where(condition);
        TypedQuery<HBUser> q = entityManager.createQuery(c);
        List<HBUser> result = q.getResultList();
        
        return result;
       
    }
    
    @Override
    public void removeUser(int userId) throws Exception {
        HBUser user = this.searchUserById(userId);

        if (user != null) {
            entityManager.remove(user);
        }
    }
    
        @Override
    public void removeTransaction(int transactionId) throws Exception {
         HBTransaction tran = this.searchTransactionById(transactionId);

        if (tran != null) {
            entityManager.remove(tran);
        }
    }
    


    //Transaction
    @Override
    public void addTransaction(HBTransaction transaction) throws Exception {
        try{
           entityManager.persist(transaction); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    @Override
    public  HBTransaction searchTransactionById(int id) throws Exception{

        HBTransaction result = entityManager.find(HBTransaction.class, id);
        
        return result;
    }
   
      @Override
    public   List<HBTransaction> searchTransactionByIdUser(int id,int userId) throws Exception{
  CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Path<String> one = u.get("id");
        Path<String> two = u.get("userId");

       
        Predicate p = qb.and(qb.equal(one, id), qb.equal(two, userId)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
        
        return result;
        
    }
    @Override
     public List<HBTransaction> searchTransactionByDescription(String description,int userId) throws Exception{
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Path<String> one = u.get("description");
        Path<String> two = u.get("userId");

       
        Predicate p = qb.and(qb.equal(one, description), qb.equal(two, userId)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
        
        return result;
     }
     
     @Override
     public List<HBTransaction> searchTransactionByDescriptionAdmin(String description) throws Exception{
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Path<String> one = u.get("description");
      
        Predicate p = qb.and(qb.equal(one, description)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
        
        return result;
     }
    @Override
     public List<HBTransaction> searchTransactionByType(String type,int userId) throws Exception{
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Path<String> one = u.get("type");
        Path<String> two = u.get("userId");

       
        Predicate p = qb.and(qb.equal(one, type), qb.equal(two, userId)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
        
        return result;
     }
     
     
     
      @Override
     public List<HBTransaction> searchTransactionByTypeAdmin(String type) throws Exception{
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Path<String> one = u.get("type");
        
        Predicate p = qb.and(qb.equal(one, type)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
        
        return result;
     }
     
    @Override
     public List<HBTransaction> searchTransactionByName(String name,int userId) throws Exception{
     CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
         Root<HBTransaction> u = c.from(HBTransaction.class);
       Path<String> one  = u.get("name");
         Path<String> two = u.get("userId");
        Predicate p = qb.and(qb.equal(one, name), qb.equal(two, userId)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
    
        
        return result;
     }
     
      @Override
     public List<HBTransaction> searchTransactionByNameAdmin(String name) throws Exception{
     CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
         Root<HBTransaction> u = c.from(HBTransaction.class);
       Path<String> one  = u.get("name");
       
        Predicate p = qb.and(qb.equal(one, name)); 
         List<HBTransaction>result =entityManager.createQuery(c.where(p)).getResultList();
    
        
        return result;
     }
     
         @Override
     public List<HBTransaction> searchTransactionByUserId(int userId) throws Exception{
     CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBTransaction> c = qb.createQuery(HBTransaction.class);
        Root<HBTransaction> u = c.from(HBTransaction.class);
        Predicate condition = qb.equal(u.get("userId"),userId);
        c.where(condition);
        TypedQuery<HBTransaction> q = entityManager.createQuery(c);
        List<HBTransaction> result = q.getResultList();
        
        return result;
     }
   
    @Override
   public List<HBUser> searchTransactionByComination(int id,String name,String type,String description,int userId){
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HBUser> c = qb.createQuery(HBUser.class);
        Root<HBUser> u = c.from(HBUser.class);
       
        Path<String> one = u.get("id");
        Path<String> two = u.get("name");
        Path<String> three= u.get("type");
        Path<String> four = u.get("description");
        Path<String> five = u.get("userId");     
        Predicate p = qb.and(qb.equal(one, id), qb.equal(two,name),qb.equal(three,type),qb.equal(four,description),qb.equal(five,userId)); 
         List<HBUser>result =entityManager.createQuery(c.where(p)).getResultList(); 
        //Predicate condition = qb.equal(u.get("lastName"), lastName);
        //,String type,String email
        
        return result;
   }

    
     @Override
    public List<Type> getAllTypes() throws Exception {
     return entityManager.createNamedQuery(Type.GET_ALL_QUERY_NAME).getResultList();
    }
    
        @Override
    public List<HBUser> getAllUsers() throws Exception {
        return entityManager.createNamedQuery(HBUser.GET_ALL_QUERY_NAME).getResultList();
   
             }

     @Override
    public List<HBTransaction> getAllTransactions() throws Exception {
        return entityManager.createNamedQuery(HBTransaction.GET_ALL_QUERY_NAME).getResultList();
   
             }
    
    @Override
    public void addType(Type type) throws Exception {
        entityManager.persist(type);
     
    }
    
    @Override
    public void removeType(int typeId) throws Exception{
     Type type = this.searchTypeById(typeId);

        if (type != null) {
            entityManager.remove(type);
        }
}

    @Override
    public Type searchTypeById(int typeId) throws Exception{

        Type type= entityManager.find(Type.class, typeId);
      
        return type;
    }
}
