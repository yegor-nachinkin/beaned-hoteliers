package ltd.very.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int addressId;  
    
    @Column(nullable = true)
    private String addressCode;
    
    @Column(nullable = false)
    private String addressCity;
    
    @Column(nullable = false)
    private String addressStreet;
    
    @Column(nullable = false)
    private String addressBuilding;
    
    @Column(nullable = true)
    private String addressFlat;
    
    //@Column(nullable = true)
    //private Company company;
    
    //@Column(nullable = true)
    //private Branch branch;    
    
    public Address(){
    }
    
    public Address(String ac, String as, String ab){
        this.addressCity = ac; this.addressStreet = as; this.addressBuilding = ab;
    }
    
    public int getAddressId(){return addressId;}
    public String getAddressCode(){return addressCode;}
    public String getAddressCity(){return addressCity;}
    public String getAddressStreet(){return addressStreet;}
    public String getAddressBuilding(){return addressBuilding;}
    public String getAddressFlat(){return addressFlat;}
    //public Company getCompany(){return company;}
    //public Branch getBranch(){return branch;}
    
    public void setAddressCode(String code){this.addressCode = code;}
    public void setAddressCity(String c){this.addressCity = c;}
    public void setAddressStreet(String s){this.addressStreet = s;}
    public void setAddressBuilding(String b){this.addressBuilding = b;}
    public void setAddressFlat(String fl){this.addressFlat = fl;}
    //public void setCompany(Company co){this.company = co;}
    //public void setBranch(Branch br){this.branch = br;}
    
    
}
