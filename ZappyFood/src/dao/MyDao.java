package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import beans.ProductBean;

public class MyDao {
	public Connection start()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappyfood","root","root");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	
	public int loginCheck(String uid,String pwd)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				x=1;
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
		
		return x;
	}
	public int insertProduct(ProductBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into product (category,pname,price,description,images)values(?,?,?,?,?)");
		    
		    ps1.setString(1,e.getCategory());
		    ps1.setString(2, e.getProductname());
		    ps1.setString(3,e.getProductprice());
		    ps1.setString(4,e.getDescription());
		    ps1.setString(5,e.getFilename());
		   
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
		
	}
	public ArrayList<ProductBean>   viewProduct()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
				e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	
	public ArrayList<ProductBean>   viewIndexProduct()
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				
				e.setFilename(rs.getString("images"));
				

				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	
	public int deleteEmp(int pid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("delete from product where pid=?");
			ps.setInt(1,pid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}

	public  ProductBean getProductDetailsByPid(int pid)
	{
		ProductBean e=new ProductBean();
		try {
				Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{ 
				
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
				e.setFilename(rs.getString("images"));
		 }
			con.close();
		}catch(  SQLException w)
			{
			  System.out.println(w);
			}
		System.out.println(e);
	return e;
		
	}

	public int updateProduct(ProductBean e)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update product set category=?,pname=?,price=?,description=? where pid=?");
			ps.setInt(5,e.getPid());
			ps.setString(1,e.getCategory());
			ps.setString(2,e.getProductname());
			ps.setString(3, e.getProductprice());
			ps.setString(4, e.getDescription());
			x= ps.executeUpdate();
	       con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}

	public int updateImage(ProductBean e) 
	{
      int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update product set images=? where pid=?");
			ps.setInt(2,e.getPid());
			ps.setString(1,e.getFilename());
			
			x= ps.executeUpdate();
	       con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}	
	
	public int SignupCheck(ProductBean e)
	{ 
		int x=0;
		
try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into customerlogin values(?,?,?,?,?)");
		    
		    ps1.setString(1,e.getName());
		    ps1.setString(2, e.getEmailid());
		    ps1.setString(3,e.getPassowrd());
		    ps1.setString(4,e.getMobileno());
		    ps1.setString(5,e.getAddress());
		    		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
	}
	
	
	
	public int CustomerLogin(String emailid,String pwd)
	{
		int x=0;
		
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from Customerlogin where emailid=? and password=?");
			ps.setString(1, emailid);
			ps.setString(2, pwd);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
				x=1;
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
		
		return x;
	}
	public int cartdetails(ProductBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into cart (pid,quantity,user)values(?,?,?)");
		    
		    ps1.setInt(1,e.getPid());
		    ps1.setString(2, e.getQuantity());
		    ps1.setString(3,e.getUser());
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
		
	return x;
		
	}
	
	public ArrayList<ProductBean>   JoinCartBean(String user)
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select c.cid,p.images,p.pname,p.price,c.quantity from product p,cart c where p.pid=c.pid And c.user=? ");
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				ProductBean e=new ProductBean();
				e.setCid(rs.getInt(1));
				e.setImage(rs.getString(2));
				e.setProductname(rs.getString(3));
				e.setQuantity(rs.getString(5));
				e.setProductprice(rs.getString(4));

				list.add(e);
				
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	
	public ArrayList<ProductBean>   cartTotal(String user)
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		ProductBean e=new ProductBean();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select sum(p.price*c.quantity)from product p,cart c WHERE p.pid=c.pid And c.user=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
			
			if(rs.next())
			{ 
				
				e.setTotal(rs.getString(("sum(p.price*c.quantity)")));
				list.add(e);
				}
			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return list;
	 }
	
	public int cartCount(String user)
	 { 
		 int count=0;
		 try {
		 Connection con = start();
		 PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM cart WHERE user=?");
		 ps.setString(1,user);	
		 ResultSet rs = ps.executeQuery();
		 
	     if(rs.next())
	     {
	    	 count=rs.getInt("COUNT(*)");
	     }
	 
	 con.close();
	 }catch(Exception e)
	 {
		 System.out.println(e);
	 }
			 return count;
	 }
	
	public int cartUpdate(String user,String IP)
    {
    	int x=0;
    	try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update cart set user=? where user=?");
			ps.setString(1, user);
			ps.setString(2, IP);
			x=ps.executeUpdate();
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
	
    	return x;
    }
    public ArrayList<ProductBean>   productDesc(int pid)
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		try {
			
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from product WHERE pid=?");
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				e.setPid(rs.getInt("pid"));
				e.setCategory(rs.getString("category"));
				e.setProductname(rs.getString("pname"));
				e.setProductprice(rs.getString("price"));
				e.setDescription(rs.getString("description"));
                e.setFilename(rs.getString("images"));
				list.add(e);
		     }
			con.close();
		}catch( SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
    public String checkEmail(String email)
    {
    	String msg=null;
    	
    	try
    	{	
    		int x=0;
    		Connection con=start();
    		String sql = "select * from customer where emailid=?";
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, email);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			x=1;
    		}
    		if(x==1)
    			msg="<font color=red>Already Exist</font>";
    		else
    			msg="<font color=green>Avaliable</font>";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
         return msg;
    }
  
    public String checkPname(String pname)
    {
    	String msg=null;
    	
    	try
    	{	
    		int x=0;
    		Connection con=start();
    		String sql = "select * from product where pname=?";
    		PreparedStatement ps = con.prepareStatement(sql);
    		ps.setString(1, pname);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			x=1;
    		}
    		if(x==1)
    			msg="<font color=red>Already Exist</font>";
    		else
    			msg="<font color=green>Avaliable</font>";
    	}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
    	
         return msg;
    }
    public int deleteCart(int cid)
	{
		int x=0;
		
		try {
			
			Connection con=start();			
			PreparedStatement ps=con.prepareStatement("delete from cart where cid=?");
			ps.setInt(1,cid);
			x= ps.executeUpdate();
	       con.close();
		}catch(SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
   public int totalUpdateCart(String q,String cid)

{
	   int x=0;
	   try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("update cart set quantity=? where cid=?");
			ps.setInt(1, Integer.parseInt(q));
			ps.setInt(2, Integer.parseInt(cid));
			x=ps.executeUpdate();
			con.close();
			}catch(  SQLException e)
		{
				System.out.println(e);
		}
	
	  return x;
}
   public int   gTotal(String user)
	{int gtot=0;
				
	   try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select sum(p.price*c.quantity)from product p,cart c WHERE p.pid=c.pid And c.user=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			//System.out.println(ps);
			
			if(rs.next())
			{ 
				
				gtot=rs.getInt(1);
				}
			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return gtot;
	 }
   public ArrayList<ProductBean>  checkOut(String user,String Add)
	{
		ArrayList<ProductBean> list=new ArrayList<>();
		ProductBean e=new ProductBean();
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select c.pid,p.price,c.quantity,c.user from product p , cart c WHERE user=?");
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			
		//	System.out.println(ps);
			while(rs.next())
			{ 
				insertOrdertable(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),Add);
								
			}
			deleteCartTable(user);

			con.close();
		}catch( SQLException ex)
			{
			  System.out.println(ex);
			}
	return list;
	 }
   public int insertOrdertable(int pid,int price,String quan,String user,String add)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into ordertable(pid,quantity,price,user,address,status)values(?,?,?,?,?,?)");
		    
			ps1.setInt(1,pid);
			ps1.setString(2,quan);
		   ps1.setInt(3, price);
			ps1.setString(4,user);
		    ps1.setString(5, add);
		   ps1.setInt(6, 0);
		    
		    x=ps1.executeUpdate(); //it not return 0 or 1 .It return no.of rows affected.
		    //System.out.println(ps1);
		    con.close();
		    }catch(Exception w)
		{
		    	System.out.println(w);
		}
	
	return x;
		
	}
   public int deleteCartTable(String user)
  	{
  		int x=0;
  		
  		try {
  			
  			ProductBean c=new ProductBean();
  			Connection con=start();			
  			PreparedStatement ps=con.prepareStatement("delete from cart where user=?");
  			ps.setString(1,user);
  			x= ps.executeUpdate();
  	       con.close();
  		}catch(SQLException w)
  			{
  			  System.out.println(w);
  			}
  		
  		return x;
  	}
   public int quantityCheck(String pid , String user)	 
	{
		int x=0;
	
		try {
			
			Connection con =start(); 
			// prepared Statement
			PreparedStatement ps = con.prepareStatement("Select * from cart where pid=? and user=?");
			ps.setInt(1, Integer.parseInt(pid));
			ps.setString(2, user);
			//System.out.println(ps);
			ResultSet rs=ps.executeQuery();
            x=0;
			if(rs.next())
          x=1;
	}catch(Exception e)
		{
		System.out.println(e);
		}
		return x;
	}
   public int updateQuantityViaCart(ProductBean e,String Quantity) {
		int x = 0;
 	try {
 		
 		//int q=Integer.parseInt(quantity);
			Connection con = start();
			PreparedStatement ps = con.prepareStatement("update cart set quantity=quantity+? where user=? and pid=?");
			ps.setInt(1, Integer.parseInt(Quantity));
			ps.setString(2, e.getUser());
			ps.setInt(3, e.getPid());
				
			x = ps.executeUpdate();
			//System.out.println(ps);
			con.close();
		} catch (SQLException w) {
			System.out.println(w);
		}
		System.out.println("update method call");
		return x;
	}
   
  
}