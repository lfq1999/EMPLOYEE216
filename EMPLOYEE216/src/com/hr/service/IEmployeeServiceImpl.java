package com.hr.service;

import java.sql.SQLException;
import java.util.List;

import com.hr.dao.EmployeeDaoImpl;
import com.hr.dao.IEmployeeDao;
import com.hr.po.Employee;

public class IEmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao ied = new EmployeeDaoImpl();
	@Override
	public List<Employee> queryAll() throws SQLException{

		return ied.queryAll();
	}

	@Override
	public void add(Employee e) throws SQLException{
		ied.add(e);
	}

	@Override
	public void update(Employee e) throws SQLException{
		ied.update(e);
	}

	@Override
	public void delete(Employee e) throws SQLException{
		ied.delete(e);
	}

	@Override
	public Employee queryByID(Employee e) throws SQLException{

		return ied.queryByID(e);
	}

}
