package ltd.very.data;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import java.util.*;

import ltd.very.entities.Address;
import ltd.very.entities.Company;
import ltd.very.entities.Branch;

public class Sqler{
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ltd.very.persistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List<String[]> getAllCompanies(){
        List<String[]> result = new ArrayList<>();
        List<Object[]> rl = em.createNativeQuery("select `companyId`,`companyName`,`companyKind` from `companies`").getResultList();
        for(Object[] objarr : rl){
            String[] row = new String[objarr.length];
            int n = 0;
            for(Object o : objarr){
                System.out.println(o.toString());
                row[n] = o.toString();
                n++;
            } 
         result.add(row);
        }
        em.clear();
        return result;
    }   
    
    public String addressToString(Address addr){
        if(addr == null){return "(No known address.)";}
        String result = addr.getAddressCode();
        if(result == null){result = "(No code) ";}else{result += " ";}
        result += addr.getAddressCity() + ", ";
        result += addr.getAddressStreet() + " ";
        result += addr.getAddressBuilding();
        if(addr.getAddressFlat() != null){result += ", " + addr.getAddressFlat();}
        return result;
    }
    
    public List<String[]> getCompanyBranches(int cid){
        List<String[]> result = new ArrayList<>();
        //List<Object[]> rl = em.createNativeQuery("select `branchName`,`branchId` from `branches` where `companyId` = " + String.valueOf(cid)).getResultList();
        Company co = em.find(Company.class, cid);
        List<Branch> branches = co.getCompanyBranches();
        for(Branch br : branches){
            String[] row = new String[2];
            row[0] = br.getBranchName();
            row[1] = String.valueOf(br.getBranchId());
            result.add(row);            
        }
        /*
        for(Object[] objarr : rl){
            String[] row = new String[2];
            row[0] = (String)objarr[0];
            row[1] = String.valueOf(objarr[1]);
            result.add(row);
        }
        */
        if(result.size() == 0){
            String[] row = new String[2];
            row[0] = "This company has no branches";
            row[1] = "";
            result.add(row); 
        }
        return result;
    }
    
    public List<String[]> getBranchAddressAndName(int bid){
        List<String[]> result = new ArrayList<>();
        Branch br = em.find(Branch.class, bid);
        String[] s = new String[4];
        s[0] = br.getBranchCompany().getCompanyName();
        s[1] = br.getBranchName();
        s[2] = addressToString(br.getBranchAddress());
        s[3] = String.valueOf(br.getBranchCompany().getCompanyId());
        result.add(s);
        em.clear();
        return result;
    }
    
    public String[] getBranchAndCompanyNamesByBranchId(int bid){
        Branch br = em.find(Branch.class, bid);
        String[] s = new String[2];
        s[0] = br.getBranchCompany().getCompanyName();
        s[1] = br.getBranchName();
        em.clear();
        return s;
    }
    
    public String getCompanyName(int cid){
        Company co = em.find(Company.class, cid);
        em.clear();
        return co.getCompanyName();
    }
    
    public List<String[]> getCompanyAddressAndName(int cid){ 
        List<String[]> result = new ArrayList<>();
        Company co = em.find(Company.class, cid); if(co == null){return result;}
        String[] s = new String[2];
        s[0] = co.getCompanyName();
        s[1] = addressToString(co.getCompanyAddress());
        result.add(s);
        em.clear();
        return result;
    }
    
}
