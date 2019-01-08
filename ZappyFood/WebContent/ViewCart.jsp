<%@page import="java.util.ArrayList,beans.ProductBean" %>
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
                                                    <li><a href="AdminHome.jsp"><font size="5px"> What's Zappy</font> </i></a>
                                                    </li>
                                                    <li><a href="AdminHome.jsp"><font size="5px"> Join us</font> </i></a>
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
                        </div>
                    </div>
                </header>
  
	${msg}
	<div class="container">
   
 <table class="table table-bordered">
 <tr><th>Image</th><th>Product Name</th><th>Quantity</th><th>Price</th></tr>
 <% 
 ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 %>
 
 <%
   for(ProductBean e:list)
   {
	  %>
   	 <tr>
   	<td><img src="imgupload/<%=e.getImage()%>" height="100"width="100" /></td>
   	<td> <%=e.getProductname()%> </td>
   	<td><%=e.getProductprice()%></td>
	<td> <%=e.getQuantity()%> </td>
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
