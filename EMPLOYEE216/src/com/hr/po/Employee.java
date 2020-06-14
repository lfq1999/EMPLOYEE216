package com.hr.po;

import java.io.Serializable;

/**
 * Employee.java类
 * @author LFQ
 *
 */

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	private int emp_id;//雇员编号
	private String emp_name;//雇员姓名
	private int emp_sex;//雇员性别
	private int emp_age;//雇员年龄
	private String emp_depart;//雇员部门
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getEmp_sex() {
		return emp_sex;
	}
	public void setEmp_sex(int emp_sex) {
		this.emp_sex = emp_sex;
	}
	public int getEmp_age() {
		return emp_age;
	}
	public void setEmp_age(int emp_age) {
		this.emp_age = emp_age;
	}
	public String getEmp_depart() {
		return emp_depart;
	}
	public void setEmp_depart(String emp_depart) {
		this.emp_depart = emp_depart;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_age;
		result = prime * result + ((emp_depart == null) ? 0 : emp_depart.hashCode());
		result = prime * result + emp_id;
		result = prime * result + ((emp_name == null) ? 0 : emp_name.hashCode());
		result = prime * result + emp_sex;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (emp_age != other.emp_age)
			return false;
		if (emp_depart == null) {
			if (other.emp_depart != null)
				return false;
		} else if (!emp_depart.equals(other.emp_depart))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (emp_name == null) {
			if (other.emp_name != null)
				return false;
		} else if (!emp_name.equals(other.emp_name))
			return false;
		if (emp_sex != other.emp_sex)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_sex=" + emp_sex + ", emp_age=" + emp_age
				+ ", emp_depart=" + emp_depart + "]";
	}
	public Employee(int emp_id, String emp_name, int emp_sex, int emp_age, String emp_depart) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_sex = emp_sex;
		this.emp_age = emp_age;
		this.emp_depart = emp_depart;
	}
	public Employee() {
		super();
	}
	
	

}
