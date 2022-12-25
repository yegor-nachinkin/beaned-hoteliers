package ltd.very.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;

import ltd.very.ejb.MyEJBee;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {
	
	@EJB
	MyEJBee ejbWrapper;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int x = request.getSession().hashCode();
        System.out.println("SESSION HASH: " + String.valueOf(x));
        x = ejbWrapper.hashCode();
        System.out.println("BEAN HASH: " + String.valueOf(x));
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>sample 5</h2>");
        if(request.getQueryString() != null){
          String[] p = request.getQueryString().split("=");
          if(!p[0].equals("words")){
            out.println("<h3>Do not know what you mean.</h3>");
          }else{            
		    if((p.length > 1) && (p[1] != null) && (!"".equals(p[1]))){
                    ejbWrapper.beanEcho(p[1]);
                    out.println("<h3>" + ejbWrapper.getEcho().replace("+", " ") + "</h3>");
                  }
            else{out.println("<h3>No shout, no echo.</h3>");}
          }
        }else{
          ejbWrapper.beanEcho("putty put");
          out.println("<h3>" + ejbWrapper.getEcho().replace("+", " ") + "</h3>");
        }
        out.println("<p><a href=\"/earness/shout.jsp\">back to main</a></p>");
        out.println("</body>");
        out.println("</html>");
	}
}
