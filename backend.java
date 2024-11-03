package login;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class RequestExample
 */
@WebServlet("/RequestExample")
public class backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestExample() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException
    {
    	super.init(config);
    	System.out.println("initialised");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		String branch = request.getParameter("branch");
		String hobbies = request.getParameter("hobbies");
		String fname = request.getParameter("fname");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Welcome"+name+"</h2>");
		out.println("<h2>Email: "+email+"</h2>");
		out.println("<h2>Course: "+course+"</h2>");
		out.println("<h2>"+branch+"</h2>");
		out.println("<h2>"+hobbies+"</h2>");
		out.println("<h2>"+fname+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void destroy() {
		System.out.println("Destory");
	}
}