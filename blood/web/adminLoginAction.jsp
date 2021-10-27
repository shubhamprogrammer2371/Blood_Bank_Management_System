<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if("Shubham".equals(username) && "Bhale".equals(password)){
        response.sendRedirect("home.jsp");
    }
    else{
        response.sendRedirect("adminLogin.jsp?msg=invalid");
    }
    %>