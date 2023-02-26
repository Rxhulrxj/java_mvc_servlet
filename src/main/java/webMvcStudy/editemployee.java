package webMvcStudy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editemployee
 */
@WebServlet("/editemployee")
public class editemployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editemployee() {
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
		int id = Integer.parseInt(request.getParameter("empId"));
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
			int count = data.UpdateData(emp,id);
			if(count > 0) {
				response.sendRedirect("listemployee.jsp");
			}else {
				pw.print("<script>alert('Something went wrong')</script>");
				pw.print("<a href='listemployee.jsp'>go back to list employee</a>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
