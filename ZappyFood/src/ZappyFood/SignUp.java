package ZappyFood;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String Cname=request.getParameter("name");
		String Cemailid=request.getParameter("emailid");
		String Cpassword=request.getParameter("password");
		String mobileno=request.getParameter("mnumber");
		String Caddress=request.getParameter("address");
		
		try {
			ProductBean e=new ProductBean();
			e.setName(Cname);
			e.setEmailid(Cemailid);
			e.setPassowrd(Cpassword);
			e.setMobileno(mobileno);
			e.setAddress(Caddress);
			
			MyDao m=new MyDao();
			int x=m.SignupCheck(e);
			
			if(x!=0)
		    {
		    javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("Signup.jsp");
		    request.setAttribute("msg","<h1>Successfully Registered...</h1>");
		    rd.forward(request, response);
		    }
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}