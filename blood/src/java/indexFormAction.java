import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author acer
 */
public class indexFormAction extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        response.setContentType("text/html");
        String name=request.getParameter("name");
        String mobilenumber=request.getParameter("mobilenumber");
        String email= request.getParameter("email");
        String bloodgroup =request.getParameter("bloodgroup");
        String status="pending";
        PrintWriter out = response.getWriter();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bloodbank","root","");
            PreparedStatement ps;
            ps = con.prepareStatement("Insert into bloodrequest(name,mobilenumber,email,bloodgroup,status) values(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,mobilenumber);
            ps.setString(3,email);
            ps.setString(4,bloodgroup);
            ps.setString(5,status);
            
               
            int inserted = ps.executeUpdate();
            
            if (inserted>0){
                System.out.print("New record ");
                response.sendRedirect("index.jsp?msg=valid");
    
            }
       
            ps.close();
                
            
        }
        catch(ClassNotFoundException | SQLException | IOException ex){
            System.out.print(""+ex);
            response.sendRedirect("index.jsp?msg=invalid");
    
        }
        out.close();
    }

}
