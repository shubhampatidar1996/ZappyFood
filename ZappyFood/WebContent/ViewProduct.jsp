<%@page import="java.util.ArrayList,beans.ProductBean" %>
 <%@include file="Header.jsp" %>
 <body style="background-color:#efeef4;">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
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
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Home</font></a> </li>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> What's Zappy</font></a> <li>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Join us</font> </a></li>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Contact Us</font></a> </li>
                                                    </li>
                                                  
                                                    
                                                        </ul>    
                                                 
                                            </nav>
                                        </div>
                                    </div>
                                    <div class="header_right_info d-flex">
                                       <ul>
                                        <li><a href="Signup.jsp">Cart</a> </li>
                                        </ul>
                                        </div>  
                        </div>
                    </div>
                </header>
  
	${msg}
 <div class="container">
   <br>
   <br>
 <table class="table table-bordered">
 <tr><th>Pid</th><th>Category</th><th>Pname</th><th>Price</th><th>Description</th><th>Image</th></tr>
 <% 
 ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(ProductBean e:list)
   {
	  %>
   	 <tr>
   	<td> <%=e.getPid()%> </td>
   	<td> <%=e.getCategory()%> </td>
	<td> <%=e.getProductname()%> </td>
	 <td><%=e.getProductprice()%> </td>
	 <td><%=e.getDescription()%> </td>
	 <td><img src="images/<%=e.getImage()%>" height="100"width="100" /></td>
	 
 <td> <a href="ProductUpdate?ppid=<%=e.getPid()%>" class="glyphicon glyphicon-edit"  onClick="return confirm('Do you really want to Update this record?')"></a> </td>
	
<td> <a href="ProductDelete?ppid=<%=e.getPid()%>" class="glyphicon glyphicon-trash"  onClick="return confirm('Do you really want to delete this record?')"></a> </td>
	 
	 <tr/>
	 <%
	 }
  %>
  
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
  </table></div>