package webMvcStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Getempdata
 */
@WebServlet("/getdata")
public class Getempdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Getempdata() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empname = request.getParameter("empname");
		String designation = request.getParameter("designation");
		double salary = Double.parseDouble(request.getParameter("salary"));
		PrintWriter pw = response.getWriter();
		EmployeeModel emp = new EmployeeModel();
		emp.setEmpname(empname);
		emp.setDesignation(designation);
		emp.setSalary(salary);
		
		EmployeeDao data = new EmployeeDao();
		try {
			System.out.println("Dao");
			int count = data.insertData(emp);
			if(count > 0) {
				response.sendRedirect("listemployee.jsp");
			}else {
				pw.print("<script>alert('Something went wrong')</script>");
			}
			pw.print("<a href='addemployee.jsp'>go back to add employee</a>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
