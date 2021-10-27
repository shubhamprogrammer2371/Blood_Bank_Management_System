<%@page import="project.*" %>
<%@page import="java.sql.*"%>
<%
String mobilenumber=request.getParameter("mobilenumber");
try{
    Connection con = ConnectionProvider.getCon();
    PreparedStatement st = con.prepareStatement("delete from bloodrequest where mobilenumber=?");
    st.setString(1,mobilenumber);
    st.executeUpdate();
    response.sendRedirect("requestForBlood.jsp");
}
catch(Exception e){
    response.sendRedirect("requestForBlood.jsp");
}
%>