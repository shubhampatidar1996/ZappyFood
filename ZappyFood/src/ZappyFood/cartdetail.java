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
 * Servlet implementation class cartdetail
 */
@WebServlet("/cartdetail")
public class cartdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartdetail() {
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
		String quantity=request.getParameter("quantity");
		String id=request.getParameter("pid");
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("uid");

		
		if(user==null)
		{
			user=request.getRemoteAddr();
			ProductBean e=new ProductBean();
			e.setQuantity(quantity);
			e.setPid(Integer.parseInt(id));
			e.setUser(user);
			MyDao obj=new MyDao();
			int x=obj.cartdetails(e);
			if(x==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "<h3>Product Added to your cart</h3>");
				rd.forward(request, response);
				}
			
		}
		else if(user!=null)
		{
			ProductBean e=new ProductBean();
			e.setQuantity(quantity);
			e.setPid(Integer.parseInt(id));
			e.setUser(user);
			MyDao obj=new MyDao();
			int x=obj.cartdetails(e);
			if(x==1)
			{
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.jsp");
				request.setAttribute("msg", "<h3>Product Added to your cart</h3>");
				rd.forward(request, response);
			}
			
		}
		else
		{
			out.println("Product Not added");
		}
		}
	}
