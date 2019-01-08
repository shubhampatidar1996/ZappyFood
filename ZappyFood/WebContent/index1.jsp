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
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Home </font></li></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> What's Zappy</font> </li></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Join us</font> </li></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Contact Us </font></li></a>
                                                    </li>
                                                    <li><a href="Signup.jsp"><font size="5px"> SignUp</font></li></a>
                                                    </li>
                                                    <li><a href="Login.jsp"><font size="5px"> Login</font></li></a>
                                                    </li>
                                                  </a>
                                                    </li>
                                                        </ul>    
                                                 </ul>
                                            </nav>
                                        </div>
                                    </div>
                  
                                    <div class="header_right_info d-flex">
                                        <span class="cart-icon-inner"></span>
                                        <li><a href="ViewCart"><font size="5px"><i class="ion-android-cart"><b><span class="cart_count">${count}</span></span>View Cart</b></i></font></a> </li>
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
ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 
 %>
 <%
   for(ProductBean ee:list)
   {
	   
	  %>

		      <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
		  
	 <table class="set" border="1" >
		<tr><td><img src="imgupload/<%=ee.getFilename()%>"  height="150" width="1700"/></td>
		</tr>
		 <tr><td><b><%=ee.getCategory()%></b></td> </tr>
		  <tr><td><b><%=ee.getProductname()%></b></td> </tr>
		       <tr><td> <b><%=ee.getProductprice()%> Rs.</b></td>  </tr>
		       <form action="./cartdetail" method="post">
		       
		       <input type="hidden" name="pid"  value="<%=ee.getPid()%>"></td></tr>
		       <tr><td><b></b>
		       <lable>Quantity</lable>
		       <input type="number" name="quantity" value="1"></td></tr>
		       <tr><td><button type="submit" class="btn btn-primary btn-sm btn-block">Add To Cart</button></td></tr>
		       <tr>  <td></td>  </tr>
		       <br>
		       </form>
	 </table>	  
	  </div>
	     
		  <%
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