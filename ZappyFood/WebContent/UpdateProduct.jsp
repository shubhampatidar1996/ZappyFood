<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
   
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
 
 <%@page import="beans.ProductBean" %>
 <%
 ProductBean e=(ProductBean)request.getAttribute("product");
 %>
 <body style="background-color:#efeef4;">
    <form action="./Update" method="post">
  
  <div class="form-group">
    <label for="pwd">Pid:</label>
    <input type="text"  value="<%=e.getPid()%>"  class="form-control" id="pwd" name="pid" />
  </div>
 
 <div class="form-group">
    <label for="category">Category:</label>
    <select name="Category">
  <option value="Ready to drink">Ready to Drink</option>
  <option value="Ready to eat">Ready to Eat</option>
  <option value="Ready to cook">Ready to Cook</option>
  </select>
  
  </div>
  <div class="form-group">
    <label for="pwd">PName:</label>
    <input type="text"  value="<%=e.getProductname()%>"  class="form-control" id="pwd" name="name" />
  </div>
  <div class="form-group">
    <label for="email">Price:</label>
    <input type="text" class="form-control"  value="<%=e.getProductprice()%>"  name="price" id="email">
  </div>
 
  <div class="form-group">
    <label for="email">Description:</label>
    <textarea name="desc" class="form-control" > <%=e.getDescription()%> </textarea>
  </div>
 
  <button type="submit" class="btn btn-default">Update</button>
</form>
</div>
</div>
	
</body>
</html>