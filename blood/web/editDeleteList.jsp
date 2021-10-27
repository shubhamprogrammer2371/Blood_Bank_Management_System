<%@page import="project.*"%>
<%@page import="java.sql.*"%>
<%@include file="header.html"%>
<html>
<head>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 95%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<br>
 <%
      String msg=request.getParameter("msg");
      if("valid".equals(msg)){
       %>
<center><font color="red" size="5">Successfully Updated</font></center>
<%
      }
  %>

<%
      
      if("invalid".equals(msg)){
       %>
<center><font color="red" size="5">SOMETHING WENT WRONG!! TRY AGAIN! </font></center>
<%
      }
  %>

<%
      
      if("deleted".equals(msg)){
       %>
<center><font color="red" size="5">SUCCESSFULLY DELETED </font></center>
<%
      }
  %>
<table id="customers">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>FATHER NAME</th>
        <th>MOTHER NAME</th>
        <th>MOBILE NUMBER</th>
        <th>GENDER</th>
        <th>EMAIL</th>
        <th>BLOOD GROUP</th>
        <th>ADDRESS</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    

        <%
        try
        {
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from donor");
        while(rs.next())
        {%>
        <tr>
        <td> <%=rs.getInt(1)%> </td>
        <td> <%=rs.getString(2)%> </td>
        <td> <%=rs.getString(3)%> </td>
        <td> <%=rs.getString(4)%> </td>
        <td> <%=rs.getString(5)%> </td>
        <td> <%=rs.getString(6)%> </td>
        <td> <%=rs.getString(7)%> </td>
        <td> <%=rs.getString(8)%> </td>
        <td> <%=rs.getString(9)%> </td>
        <td><a href="updateDonor.jsp?id=<%=rs.getString(1) %> ">Edit</a></td>
        <td><a href="deleteDonor.jsp?id=<%=rs.getString(1) %> ">Delete</a></td>
    </tr>
        <%}}
        catch(Exception e)
        {
          System.out.println(e);
        }
        %>
</table>
</center>
<br>
<br>
<br>
<br>
<h3><center>All Right Reserved @SHUBHAM :: 2021  </center></h3>
</body>
</html>