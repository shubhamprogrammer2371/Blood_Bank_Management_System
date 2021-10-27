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
public class addNewDonorAction extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        response.setContentType("text/html");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String father=request.getParameter("father");
        String mother=request.getParameter("mother");
        String mobilenumber=request.getParameter("mobilenumber");
        String gender=request.getParameter("gender");
        String email=request.getParameter("email");
        String bloodgroup=request.getParameter("bloodgroup");
        String address=request.getParameter("address");
        PrintWriter out = response.getWriter();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bloodbank","root","");
            PreparedStatement ps;
            ps = con.prepareStatement("Insert into donor values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,father);
            ps.setString(4,mother);
            ps.setString(5,mobilenumber);
            ps.setString(6,gender);
            ps.setString(7,email);
            ps.setString(8,bloodgroup);
            ps.setString(9,address);
               
            int inserted = ps.executeUpdate();
            
            if (inserted>0){
                System.out.print("New record ");
                response.sendRedirect("addNewDonor.jsp?msg=valid");

            }
       
            ps.close();
                
            
        }
        catch(ClassNotFoundException | SQLException | IOException ex){
            System.out.print(""+ex);
            response.sendRedirect("addNewDonor.jsp?msg=invalid");}

        }
        
    }


