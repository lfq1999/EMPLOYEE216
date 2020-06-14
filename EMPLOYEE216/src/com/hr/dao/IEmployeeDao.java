package com.hr.dao;

import java.sql.SQLException;
import java.util.List;

import com.hr.po.Employee;

public interface IEmployeeDao {
	// 查询所有雇员信息的方法
	public List<Employee> queryAll() throws SQLException;

	// 添加雇员信息的方法
	public void add(Employee e) throws SQLException;

	// 修改雇员信息的方法
	public void update(Employee e) throws SQLException;

	// 删除雇员信息的方法
	public void delete(Employee e) throws SQLException;

	// 根据雇员编号查询雇员信息的方法
	public Employee queryByID(Employee e) throws SQLException;
	
	//根据雇员信息中的关键字实现模糊查询的方法
	public List<Employee> queryByName(Employee e) throws SQLException;

}
