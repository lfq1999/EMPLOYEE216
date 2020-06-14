package com.hr.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hr.po.Employee;
import com.hr.service.IEmployeeServiceImpl;


@WebServlet(name="EmployeeServlet",urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEmployeeServiceImpl ies = new IEmployeeServiceImpl();
    public EmployeeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //处理字符编码问题
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //查询显示所有雇员信息
        String action = request.getParameter("action");
        if("add".equals(action)) {
        	add(request, response);
        }else if("update".equals(action)) {
        	update(request, response);
        }else if("delete".equals(action)) {
        	delete(request, response);
        }else if("queryAll".equals(action)) {
        	queryAll(request, response);
        }else if("queryByID".equals(action)) {
        	queryByID(request, response);
        }
	}    
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String dept = request.getParameter("dept");
		Employee e = new Employee(0,name,Integer.parseInt(sex),Integer.parseInt(age),dept);
		try {
			ies.add(e);
			queryAll(request, response);//tian jia cheng gong hou fan hui dao gu yuan ye mian
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String dept = request.getParameter("dept");
		Employee e = new Employee(Integer.parseInt(id),name,Integer.parseInt(sex),Integer.parseInt(age),dept);
		try {
			ies.update(e);
			queryAll(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		Employee emp = new Employee();
		emp.setEmp_id(Integer.parseInt(emp_id));
		try {
			ies.delete(emp);
			queryAll(request, response);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	private void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> elist = ies.queryAll();
			request.setAttribute("list", elist);
			request.getRequestDispatcher("employeelist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		Employee e = new Employee();
		e.setEmp_id(Integer.parseInt(emp_id));
		try {
			Employee emp = ies.queryByID(e);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("updateEmployee.jsp").forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


}
