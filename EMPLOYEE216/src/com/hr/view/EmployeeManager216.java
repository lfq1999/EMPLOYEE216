package com.hr.view;
/**
 * @author LFQ
 * 雇员管理系统业务界面类
 */

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.hr.dao.EmployeeDaoImpl;
import com.hr.dao.IEmployeeDao;
import com.hr.po.Employee;

public class EmployeeManager216 {
	static Scanner sc = new Scanner(System.in);
	static IEmployeeDao ied = new EmployeeDaoImpl();
	public static void main(String[] args) {
		int cmd = 1;
		while(true) {
			System.out.println("|--------------雇员管理系统-------------|");
			System.out.println("|1-增加 2-删除 3-修改 4-查找 5-显示所有 0-退出-|");
			System.out.println("|------------------------------------|");
			System.out.println("请选择业务：");
			cmd = sc.nextInt();
			if(cmd==0) {
				break;
			}
			switch (cmd) {
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				queryLike();
				break;
			case 5:
				queryAll();
				break;
			default:
				System.out.println("你输入的命令有误，请检查确认后重新输入！");
				break;
			}
		}
		
		
	}
	public static void add() {
		System.out.println("-----------------增加-------------");
		System.out.println("雇员姓名：");
		String name = sc.next();
		System.out.println("雇员性别[1-男，2-女]：");
		int sex = sc.nextInt();
		System.out.println("雇员年龄：");
		int age = sc.nextInt();
		System.out.println("雇员部门：");
		String depart = sc.next();
		
		Employee e = new Employee(0,name,sex,age,depart);
		try {
			ied.add(e);
			System.out.println("增加成功--------------------");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void delete() {
		System.out.println("---------------删除---------------");
		System.out.println("请输入要删除雇员的编号");
		int no = sc.nextInt();
		Employee emp = new Employee();
		emp.setEmp_id(no);
		try {
			emp = ied.queryByID(emp);
			System.out.println(emp.toString());
			
			System.out.println("确认要删除吗？1-是，2-否");
			int cmd = sc.nextInt();
			if(1==cmd) {
				ied.delete(emp);
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void update() {
		System.out.println("--------------修改----------------");
		System.out.println("请输入需要修改雇员的编号：");
		int no = sc.nextInt();
		Employee emp = new Employee();
		emp.setEmp_id(no);
		try {
			emp = ied.queryByID(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(emp.toString());
		System.out.println("请重新输入雇员信息：");
		System.out.println("雇员姓名：");
		String name = sc.next();
		System.out.println("雇员性别[1-男，2-女]：");
		int sex = sc.nextInt();
		System.out.println("雇员年龄：");
		int age = sc.nextInt();
		System.out.println("雇员部门：");
		String depart = sc.next();
		Employee em = new Employee(no,name,sex,age,depart);
		try {
			ied.update(em);
			System.out.println("修改成功--------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void queryAll() {
		System.out.println("-------------查询所有----------------");
		
		try {
			List<Employee> list = ied.queryAll();
			for(Employee em:list) {
				System.out.println(em.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void queryLike() {
		System.out.println("------------模糊查询--------------");
		System.out.println("请输入查询关键字：");
		String name = sc.next();
		Employee emp = new Employee();
		emp.setEmp_name(name);
		
		try {
			List<Employee> list = ied.queryByName(emp);
			for(Employee em:list) {
				System.out.println(em.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
