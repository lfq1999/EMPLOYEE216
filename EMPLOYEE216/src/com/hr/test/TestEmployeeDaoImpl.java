package com.hr.test;

import java.sql.SQLException;
import java.util.List;

import com.hr.dao.EmployeeDaoImpl;
import com.hr.po.Employee;

public class TestEmployeeDaoImpl {

	public static void main(String[] args) throws Exception{
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.update(new Employee(1,"李晓明",1,25,"行政部"));
		edi.update(new Employee(2,"杨伟林",1,29,"行政部"));
//		edi.add(new Employee(0, "嘻嘻",1,25,"行政部"));
		edi.delete(new Employee(4,"",0,0,""));
		List<Employee> list = edi.queryAll();
		System.out.println(list.toString());


	}

}
