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
public class updateDonorAction extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
       response.setContentType("text/html");
       String id =request.getParameter("id");
       String name =request.getParameter("name");
       String father =request.getParameter("father");
       String mother =request.getParameter("mother");
       String mobilenumber =request.getParameter("mobilenumber");
       String email =request.getParameter("email");
       String address =request.getParameter("address");
       PrintWriter out = response.getWriter();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bloodbank","root","");
            PreparedStatement ps;
            ps = con.prepareStatement("update donor set name=?,father=?,mother=?,mobilenumber=?,email=?,address=? where id=?");
            ps.setString(1,name);
            ps.setString(2,father);
            ps.setString(3,mother);
            ps.setString(4,mobilenumber);
            ps.setString(5,email);
            ps.setString(6,address);
            ps.setString(7,id);
   
               
            int inserted = ps.executeUpdate();
            
            if (inserted>0){
                System.out.print("New record ");
                response.sendRedirect("editDeleteList.jsp?msg=valid");

            }
       
            ps.close();
                
            
        }
        catch(ClassNotFoundException | SQLException | IOException ex){
            System.out.print(""+ex);
            response.sendRedirect("editDeleteList.jsp?msg=invalid");}

        }
        
    }

