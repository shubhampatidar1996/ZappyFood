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

import dao.MyDao;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
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
		String u=request.getParameter("emailid");
		String p=request.getParameter("password");
		
		MyDao m=new MyDao();
		   int x=m.CustomerLogin(u, p);
		   
		   if(x==1)
			{
			   //Session code here
				HttpSession session=request.getSession();
				session.setAttribute("uid",u);
				response.sendRedirect("CustomerHome.jsp");
				
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("Clogin.jsp");
				request.setAttribute("msg","Login failed try again...");
				rd.forward(request,response);
				  //response.sendRedirect("index.jsp");
			}
		
	}
	}
