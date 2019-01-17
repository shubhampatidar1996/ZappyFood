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
	
	<table class="table table-hover" style="
    margin-top: 65px;">
 <tr><th>Pimage</th><th>Pname</th><th>Price</th><th>Quantity</th><th>Total</th></tr>
 <% 
 ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 
 %>
 <%
 int i=0;
   for(ProductBean ee:list)
   {
	  %>
	  <%
 int price=Integer.parseInt(ee.getProductprice());
 int quantity=Integer.parseInt(ee.getQuantity());
	  
 %>
 
   	 <tr>
   <input type="hidden"   value="<%=ee.getCid()%>" readonly  name="cid" id="cid<%=i %>" />
   	<td> <img src="imgupload/<%=ee.getImage()%>" height="100"width="165" /> </td>
   	<td> <%=ee.getProductname()%> </td>
   	<td> <input type="text"   value="<%=ee.getProductprice()%>" readonly name="price" id="p<%=i%>"/>
   	 </td>
   	<td > 
     <input type="text" value="<%=ee.getQuantity()%>" name="qunatity" id="q<%=i %>" onKeyUp="check(<%=i%>);"/> 
    </td>
	<td> <input type="text" value="<%=price*quantity%>" readonly name="t" id="total<%=i%>"> </td>
	<td> <a href="CartDelete?cartid=<%=ee.getCid()%>" class="glyphicon glyphicon-remove-sign"  onClick="return confirm('Do you really want to delete this record?')"></a> </td>
	
	 <tr/>
	 <%i++;
	 }
  %>
 </table></div>
 <%ArrayList<ProductBean> listt=(ArrayList<ProductBean>)request.getAttribute("LISTT"); %>
 <% 
 for(ProductBean ee:listt)
 {
	 
	  %>
	<div class="col-lg-11 col-sm-11 col-md-11">
	 <div class="cart_totals text-right">
	  <h1>Cart Total</h1>
	  <div class="order-total">
	  <span><strong><h3>Grand Total:</h3></strong></span>
	 <strong><h3> <div id="gtot"><%=ee.getTotal() %></div></h3></strong>
    </div>
    </div>
    </div>
   
 <%
	 }
  %>
  <div class="container">
	<div class="col-sm-6">
<form action="CheckOut" method="post">
<div class="form-group">
    <label for="address">Delivery Address:</label>
   <textarea name="daddress" class="form-control" ></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Check Out</button>
</form>
</div>
</div>
  
  <script type="text/javascript">
function check(i) 
{
	 var q=document.getElementById('q'+i).value;
	  var up=document.getElementById('p'+i).value;
	  var cid=document.getElementById('cid'+i).value;
	 document.getElementById('total'+i).value=q*up;
	 
	  var xhttp = new XMLHttpRequest();
	  //
	 // var quantity=document.getElementById('q').value;
	  xhttp.open("POST", "UpdateViewCart?cid="+cid+"&q="+q, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("gtot").innerHTML = this.responseText;
	    
	    	   }
	  };
	  
	}
</script>
  
  

  </body>
