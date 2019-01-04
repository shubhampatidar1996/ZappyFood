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
			PreparedStatement ps=con.prepareStatement("select category,pname,price,images from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				
			{ 
				ProductBean e=new ProductBean();
				
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

	public int SignupCheck(ProductBean e)
	{ 
		int x=0;
		
		try {
			
			Connection con=start();
			PreparedStatement ps1=con.prepareStatement("insert into customerlogin (name,emailid,password,address)values(?,?,?,?)");
		    
		    ps1.setString(1,e.getName());
		    ps1.setString(2, e.getEmailid());
		    ps1.setString(3,e.getPassowrd());
		    ps1.setString(4,e.getAddress());
		   
		    
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
			PreparedStatement ps=con.prepareStatement("select p.images,p.pname,p.price,c.quantity from product p,cart c where p.pid=c.pid");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				ProductBean e=new ProductBean();
				e.setImage(rs.getString(1));
				e.setProductname(rs.getString(2));
				e.setQuantity(rs.getString(3));
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
	
}