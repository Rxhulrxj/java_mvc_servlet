package webMvcStudy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public int insertData(EmployeeModel model) throws ClassNotFoundException, SQLException {
		String url = "Insert into employee_1(empname,designation,salary) values(?,?,?)";
		Dbconnect db = new Dbconnect();
		PreparedStatement ps = db.con.prepareStatement(url);
		ps.setString(1, model.getEmpname());
		ps.setString(2, model.getDesignation());
		ps.setDouble(3, model.getSalary());
		System.out.println("Going to insert data");
		return ps.executeUpdate();
	}
	
	public List<EmployeeModel> getEmployee() throws ClassNotFoundException, SQLException {
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		String query = "Select * from employee_1";
		Dbconnect db = new Dbconnect();
		ResultSet rs = db.getdata(query);
		while(rs.next()) {
			EmployeeModel emp = new EmployeeModel();
			emp.setId(rs.getInt(1));
			emp.setEmpname(rs.getString(2));
			emp.setDesignation(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			list.add(emp);
		}
		return list;
	}
	
	public List<EmployeeModel> getEmployeeById(int id) throws ClassNotFoundException, SQLException {
		List<EmployeeModel> list = new ArrayList<EmployeeModel>();
		String query = "Select * from employee_1 where id="+ id;
		Dbconnect db = new Dbconnect();
		ResultSet rs = db.getdata(query);
		while(rs.next()) {
			EmployeeModel emp = new EmployeeModel();
			emp.setId(rs.getInt(1));
			emp.setEmpname(rs.getString(2));
			emp.setDesignation(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			list.add(emp);
		}
		return list;
	}
	public int UpdateData(EmployeeModel model,int id) throws ClassNotFoundException, SQLException {
		String url = "Update employee_1 set empname=?,designation=?,salary=? where id="+id;
		Dbconnect db = new Dbconnect();
		PreparedStatement ps = db.con.prepareStatement(url);
		ps.setString(1, model.getEmpname());
		ps.setString(2, model.getDesignation());
		ps.setDouble(3, model.getSalary());
		System.out.println("Going to update data");
		return ps.executeUpdate();
	}
	public int DeleteData(int id) throws ClassNotFoundException, SQLException {
		String url = "Delete  from employee_1 where id="+id;
		Dbconnect db = new Dbconnect();
		return db.stmt.executeUpdate(url);
	}
}
