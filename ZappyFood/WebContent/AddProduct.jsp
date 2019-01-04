<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
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
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Home</font> </i></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> What's Zappy </font></i></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Join us </font></i></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Contact Us</font> </i></a>
                                                    </li>
                                                  </a>
                                                    </li>
                                                        </ul>    
                                                 </ul>
                                            </nav>
                                        </div>
                                    </div>
                                    <div class="header_right_info d-flex">
                                       
                                        <li><a href=""><font size="5px">View Cart</font></a> </li>
                                        </div>  
                        </div>
                    </div>
                </header>
   
       <% 
	  	String uid=(String)session.getAttribute("uid");
	  
       if(uid==null)
    	   response.sendRedirect("index.jsp");
       
       %>
	   
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	
	</center>
	
<% String m=(String)request.getAttribute("msg"); 
    if(m!=null)
    {
  %>	
	<div class="alert alert-success alert-dismissible">
  <strong><%=m%></strong> 
</div>
<%
}
    %>


	<div class="container">
	<div class="col-sm-3">
    <form action="./UploadProduct" method="post" enctype="multipart/form-data">
 
  <div class="form-group">
    <label for="category">Category:</label>
    <select name="Category">
  <option value="Ready to drink">Ready to Drink</option>
  <option value="Ready to eat">Ready to Eat</option>
  <option value="Ready to cook">Ready to Cook</option>
  </select>
  </div>
 
  <div class="form-group">
    <label for="pname">Product Name:</label>
     <input type="text" class="form-control" name="pname" id="Pname">
     </div>
 
  <div class="form-group">
    <label for="price">Price:</label>
    <input type="text" class="form-control" name="price" id="Price">
  </div>
 
  <div class="form-group">
    <label for="description">Description:</label>
   <textarea name="description" class="form-control" ></textarea>
  </div>
  
  <div class="form-group">
    <label for="image">Image:</label>
   <input type="file" class="form-control" id="file"  name="file" />
  </div>
  
     <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</div>
	
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