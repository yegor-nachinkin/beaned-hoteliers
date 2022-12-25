package ltd.very.bean;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import ltd.very.entities.*;

import java.util.*;

@Stateless
public class DataBean implements Serializable {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ltd.very.persistenceUnit");
    EntityManager em = emf.createEntityManager();
    
    public int addNewCompany(String cn, String ck){
        int result = 0;
        Company co = new Company(cn, ck);
        em.getTransaction().begin();
        em.persist(co);
        em.getTransaction().commit();   
        result = co.getCompanyId();     
        em.clear();
        return result;
    }
    
    public int addNewCompanyBranch(String bname, int cid){
        int result = 0;
           Company co = em.find(Company.class, cid); 
           Branch br = new Branch(bname, co);
           em.getTransaction().begin();
           em.persist(br);
           em.getTransaction().commit();
           result = br.getBranchId();
           em.clear();
        return result;
    }
    
    public boolean addCompanyBranchToCompany(int cid, int bid){
        boolean result = false;
           Company co = em.find(Company.class, cid);
           System.out.println("Company name: " + co.getCompanyName());
           Branch br = em.find(Branch.class, bid);
           System.out.println("Branch name: " + br.getBranchName());
           int x1 = co.getCompanyBranches().size();
           System.out.println("Number of branches: " + String.valueOf(x1));
           if(!co.getCompanyBranches().contains(br)){
             co.getCompanyBranches().add(br);
             System.out.println("Company branch added to company.");
           }else{
             System.out.println("Branch already belongs to company.");
             return result;  
           }
           em.getTransaction().begin();
           em.merge(co);
           em.getTransaction().commit();
           result = co.getCompanyBranches().size() - x1 == 1;
           em.clear();
        return result;
    }
    
    public int addNewAddress(String ac, String as, String ab){
        int result = 0;
        Address ad = new Address(ac, as, ab);
        em.getTransaction().begin();
        em.persist(ad);
        em.getTransaction().commit();
        result = ad.getAddressId();
        em.clear();
        return result;        
    }
    
    public boolean companyExistsWithCompanyId(int companyId){
        return em.find(Company.class, companyId) != null;
    }
    
    public List<String[]> allCompaniesAsStringArrays(){
        List<String[]> result = new ArrayList<>();
        List<Object[]> rl = em.createNativeQuery("select * from `companies`").getResultList();
        for(Object[] objarr : rl){
            String[] row = new String[objarr.length];
            int n = 0;
            for(Object o : objarr){
                //System.out.println(o.toString());
                row[n] = o.toString();
                n++;
            } 
         result.add(row);
        }
        return result;
    }
    
    public Address getCompanyAddress(int companyId){
        return em.find(Company.class, companyId).getCompanyAddress();
    }
    
    public boolean setCompanyAddress(int companyId, int addressId){
        boolean result = false;
        Company co = em.find(Company.class, companyId); if(co == null){return result;}
        Address adr = em.find(Address.class, addressId); if(adr == null){return result;}
        em.getTransaction().begin();
        co.setCompanyAddress(adr);
        em.getTransaction().commit();
        em.clear();
        return co.getCompanyAddress() == adr;
    }
    
    public boolean setBranchAddress(int branchId, int addressId){
        boolean result = false;
        Branch br = em.find(Branch.class, branchId); if(br == null){return result;}
        Address adr = em.find(Address.class, addressId); if(adr == null){return result;}
        em.getTransaction().begin();
        br.setBranchAddress(adr);
        em.getTransaction().commit();
        em.clear();
        return br.getBranchAddress() == adr;
    }    

}
