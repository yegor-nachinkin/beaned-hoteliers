package ltd.very.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.io.Serializable;

@Entity
@Table(name = "companies")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int companyId;

    @Column
    private String companyName;
    
    @Column
    private String companyKind;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address companyAddress;
    
    @OneToMany(mappedBy ="branchCompany", fetch = FetchType.EAGER)
    @Column(nullable = true)
    private List<Branch> companyBranches;
    
    public Company(){
    }
    
    public Company(String cn, String ck){
      this.companyName = cn; this.companyKind = ck;
    }
    
    public int getCompanyId() {return companyId;}
    public void setCompanyId(int id) {this.companyId = id;}

    public String getCompanyName(){return companyName;}
    public void setCompanyName(String n){this.companyName = n;}
    
    public String getCompanyKind(){return companyKind;}
    public void setCompanyKind(String k){this.companyKind = k;} 
    
    public Address getCompanyAddress(){return companyAddress;}
    public void setCompanyAddress(Address adr){this.companyAddress = adr;} 
    
    public List<Branch> getCompanyBranches(){return companyBranches;} 
    public void setCompanyBranches(List<Branch> cb){this.companyBranches = cb;}    
}
