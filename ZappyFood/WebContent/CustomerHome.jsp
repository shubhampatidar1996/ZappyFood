<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@page import="java.util.ArrayList,beans.ProductBean" %>
<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<head>
  <title></title>
  <meta charset="utf-8">
 <%@include file="Header.jsp" %>
 

</head>
<body style="background-color:#efeef4;">

<div class="organic_food_wrapper">
                <!--Header start-->
                <header class="header sticky-header" style="background-color:#c3c1ad">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-12">
                                <div class="header_wrapper_inner">
                                   
                                    <div class="logo col-xs-12">
                                        <a href="index.html">
                                            <img src="assets/img/zappy-logo.png" alt="">
                                        </a>
                                    </div>
                                    <br>
                                    
                                    <div class="main_menu_inner">
                                      
                                        <div class="menu">
                                            <nav>
                                                <ul>
                                                    <li><a href="ViewCart"><font size="5px">View Cart</font></i></a>
                                                    </li>
                                                    <li><a href=""><font size="5px"> Order History</font> </i></a>
                                                    </li>

                                                        </ul>    
                                                 </ul>
                                            </nav>
                                        </div>
                                    </div>
                                    <div class="header_right_info d-flex">
                                       
                                        <li><a href="Logout.jsp"><font size="5px">Logout</font></a> </li>
                                        </div>  
                        </div>
                    </div>
                </header>

<br>

 
 <%--
 ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 
 %>
 <div class="container" 
    style="padding-top: 95px;"
 >
 <%
   for(ProductBean ee:list)
   {
	   
	  %>
	  
	  <div class="col-lg-3 col-md-4 col-xs-6">
	  <table border="3" >
	  
   	 <tr>
   	 
   	<td><img src="imgupload/<%=ee.getFilename()%>" height="100"width="100" /></td>
   	</tr>
   	<tr>
   	<td> <%=ee.getCategory()%> </td></tr>
   	<tr>
	<td> <%=ee.getProductname()%> </td></tr>
	<tr> <td><%=ee.getProductprice()%> </td><tr>
	 
	 
	 
	 
	</table>
	 </div>  
	 <%
	 }
  --%>
  
   <%@page import="java.sql.*" %>
<div class="container">
  <div class="row">

<%
try {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappyfood","root","root");
	  PreparedStatement ps=con.prepareStatement("select  * from product");
	  ResultSet rs=ps.executeQuery();
	  %>
	 
	  <%
	  while(rs.next())
	  {
		  %>
		      <div class="col-lg-3 col-md-4 col-xs-6">
		  
	 <table class="set" border="1" >
		<td><img src="images/<%=rs.getString("images")%>" height="150"width="1700" /></td>
		</tr>
		 <tr><td><%=rs.getString("category")%></td> </tr>
		  <tr><td><%=rs.getString("pname")%></td> </tr>
		       <tr><td>MRP:-<%=rs.getString("price")%> Rs.</td>  </tr>
		       <tr><td><b></b>  
		       <form action="./cartdetail" method="post">
		       
		       <input type="text" name="pid" hidden value="<%=rs.getInt("pid")%>"></td></tr>
		       <tr><td><b></b>
		       <lable>Quantity</lable>
		       <input type="number" name="quantity" value="1" ></td></tr>
		       <tr><td><button type="submit" class="btn btn-primary btn-sm btn-block">Add To Cart</button></td></tr>
		       <tr>  <td></td>  </tr>
		       <br>
		       </form>
	 </table>	  
	  </div>
	     
		  <%
	  }
	  
	  %>
	  
	  <%
	  con.close();
}catch(Exception e)
{
	  System.out.println(e);
}
%>
</div>
  </div>
  
               
                
                <!-- all js here -->
        <script src="assets/js/vendor/jquery-1.12.0.min.js"></script>
        <script src="assets/js/popper.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.meanmenu.min.js"></script>
        <script src="assets/js/isotope.pkgd.min.js"></script>
        <script src="assets/js/imagesloaded.pkgd.min.js"></script>
        <script src="assets/js/jquery.counterup.min.js"></script>
        <script src="assets/js/waypoints.min.js"></script>
        <script src="assets/js/ajax-mail.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/plugins.js"></script>
        <script src="assets/js/main.js"></script>
  
  </body>
  
  
  
  </html>