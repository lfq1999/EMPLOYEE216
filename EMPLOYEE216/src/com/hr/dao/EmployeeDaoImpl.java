package com.hr.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hr.po.Employee;
import com.hr.util.DBUtils;

public class EmployeeDaoImpl implements IEmployeeDao {
	private QueryRunner qr = null;//查询运行器
	public EmployeeDaoImpl() {
		qr = new QueryRunner();
	}
		


	@Override
	public List<Employee> queryAll() throws SQLException{
		String sql = "select * from employee";
		List<Employee> list = qr.query(DBUtils.getConnection(), sql, new BeanListHandler<Employee>(Employee.class));
		return list;
	}
	public void add(Employee e) throws SQLException{
		String sql = "insert into employee (emp_name,emp_sex,emp_age,emp_depart) values(?,?,?,?)";
		qr.update(DBUtils.getConnection(),sql,e.getEmp_name(),e.getEmp_sex(),e.getEmp_age(),e.getEmp_depart());
	}

	@Override
	public void update(Employee e) throws SQLException{
		String sql = "update employee set emp_name=?,emp_sex=?,emp_age=?,emp_depart=? where emp_id=?";
		qr.update(DBUtils.getConnection(),sql,e.getEmp_name(),e.getEmp_sex(),e.getEmp_age(),e.getEmp_depart(),e.getEmp_id());
	}

	@Override
	public void delete(Employee e) throws SQLException{
		String sql = "delete from employee where emp_id=?";
		qr.update(DBUtils.getConnection(),sql,e.getEmp_id());
	}

	@Override
	public Employee queryByID(Employee e) throws SQLException{
		String sql = "select * from employee where emp_id=?";
		Employee emp = qr.query(DBUtils.getConnection(),sql,new BeanHandler<Employee>(Employee.class),e.getEmp_id());
		return emp;
	}



	@Override
	public List<Employee> queryByName(Employee e) throws SQLException {
		String sql = "select * from employee where emp_name like ?";
		List<Employee> list = qr.query(DBUtils.getConnection(), sql, new BeanListHandler<Employee>(Employee.class),"%"+e.getEmp_name()+"%");
		return list;
	}

}
