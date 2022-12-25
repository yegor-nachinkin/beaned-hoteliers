package ltd.very.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "branches")
public class Branch implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int branchId;

    @NotNull
    @Column
    private String branchName;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private Company branchCompany;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address branchAddress;
    
    public Branch(){
    }
    
    public Branch(String bname, Company co){
        this.branchName = bname; this.branchCompany = co;
    }
    
    public int getBranchId() {return branchId;}
    public void setBranchId(int id) {this.branchId = id;}

    public String getBranchName(){return branchName;}
    public void setBranchName(String n){this.branchName = n;}
    
    public Company getBranchCompany(){return branchCompany;}
    public void setBranchCompany(Company co){this.branchCompany = co;} 
    
    public Address getBranchAddress(){return branchAddress;}
    public void setBranchAddress(Address adr){this.branchAddress = adr;}     
}
