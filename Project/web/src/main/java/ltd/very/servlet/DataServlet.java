package ltd.very.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;

import ltd.very.bean.DataBean;

@WebServlet("/data")
public class DataServlet extends HttpServlet {
	
	@EJB
	DataBean dataBean;
    
    public List<String[]> queryResult;
    
    public void allCompanies(){
       queryResult = dataBean.allCompaniesAsStringArrays();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int x = request.getSession().hashCode();
        System.out.println("SESSION HASH: " + String.valueOf(x));
        x = dataBean.hashCode();
        System.out.println("BEAN HASH: " + String.valueOf(x));
        PrintWriter out = response.getWriter();
        out.println("Data Servlet");
        if(request.getQueryString() != null){
            String[] bits = request.getQueryString().split("&");
            if((bits != null) && (bits.length > 0)){
                Map<String, String> m = new HashMap<>();
                for(String s : bits){
                    String[] arg = s.split("=");
                    if((arg != null) && (arg.length > 1)){
                        m.put(arg[0],arg[1]);
                    }
                }
                // GET 'http://localhost:8080/earness/data?addNewCompany=1&companyName=Mad_Bankrupts&companyKind=OOO'
                if(m.containsKey("addNewCompany") && (m.containsKey("companyName")) && (m.containsKey("companyKind"))){
                    int r = dataBean.addNewCompany(m.get("companyName").replace("_"," "), m.get("companyKind"));
                    out.println("New company added, id: " + String.valueOf(r));
                }else
                // GET 'http://localhost:8080/earness/data?addNewBranch=1&branchName=Special_Store&companyId=1'
                if(m.containsKey("addNewBranch") && (m.containsKey("branchName")) && (m.containsKey("companyId"))){
                    int r = dataBean.addNewCompanyBranch(m.get("branchName").replace("_"," "), Integer.parseInt(m.get("companyId")));
                    if(r > 0){out.println("New company branch added, id: " + String.valueOf(r));}
                    else{out.println("No company found with id " + m.get("companyId"));}
                }else
                // GET 'http://localhost:8080/earness/data?addNewAddress=1&addressCity=Rotten_Hole&addressStreet=Sad_Lane&addressBuilding=13b'
                if(m.containsKey("addNewAddress") && m.containsKey("addressCity") && m.containsKey("addressStreet") && m.containsKey("addressBuilding")){
                    int r = dataBean.addNewAddress(m.get("addressCity").replace("_"," "), m.get("addressStreet").replace("_"," "), m.get("addressBuilding").replace("_"," ")); 
                    if(r > 0){out.println("New address added, id: " + String.valueOf(r));}
                    else{out.println("No company found with id " + m.get("companyId"));}
                }else
                if(m.containsKey("allCompanies")){
                    out.println("ALL COMPANIES");
                    allCompanies();
                }else
                // GET 'http://localhost:8080/earness/data?setCompanyAddress=1&addressId=18'
                if(m.containsKey("setCompanyAddress") && m.containsKey("addressId")){
                    System.out.println("Setting company address...");
                    boolean r = dataBean.setCompanyAddress(Integer.parseInt(m.get("setCompanyAddress")), Integer.parseInt(m.get("addressId"))); 
                    if(r){out.println("Company address set.");}
                    else{out.println("Could not set company address as you wish.");}
                }else
                // GET 'http://localhost:8080/earness/data?setBranchAddress=8&addressId=18'
                if(m.containsKey("setBranchAddress") && m.containsKey("addressId")){
                    System.out.println("Setting branch address...");
                    boolean r = dataBean.setBranchAddress(Integer.parseInt(m.get("setBranchAddress")), Integer.parseInt(m.get("addressId"))); 
                    if(r){out.println("Branch address set.");}
                    else{out.println("Could not set branch address as you wish.");}
                }
            }
        }
	}
}
