package jDBC_DAO_DTO;

import jDBC.Empleado;

public class EmpleadoDTO implements Comparable<Empleado> {

	
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private int salary;
	private int commission_pct;
	private String manager_id;
	private String departament_id;
	
	
	public EmpleadoDTO(String employee_id, String first_name, String last_name,
			String email, String phone_number, String hire_date, String job_id,
			int salary, int commission_pct, String manager_id,
			String departament_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.departament_id = departament_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res="";
		res += "-------------------------------------\n";
		res += "EMPLOYEE_ID: " + this.employee_id + "\n";
		res += "FIRST_NAME: " + this.first_name + "\n";
		res += "LAST_NAME: " + this.last_name + "\n";
		res += "EMAIL: " + this.email + "\n";
		res += "PHONE_NUMBER: " + this.phone_number + "\n";
		res += "HIRE_DATE: " + this.hire_date + "\n";
		res += "JOB_ID: " + this.job_id + "\n";
		res += "SALARY: " + this.salary + "\n";
		res += "COMMISSION_PCT: " + this.commission_pct + "\n";
		res += "MANAGER_ID: " + this.manager_id+ "\n";
		res += "DEPARTAMENT_ID: " + this.departament_id+ "\n";
		res += "-------------------------------------\n";
		//return this.first_name + " " + this.last_name + " " + this.salary;
		return res;
	}
	
	
	@Override
	public int compareTo(Empleado e) {
		return  e.getSalary() - this.getSalary();
	}
	
	
	

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCommission_pct() {
		return commission_pct;
	}

	public void setCommission_pct(int commission_pct) {
		this.commission_pct = commission_pct;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getDepartament_id() {
		return departament_id;
	}

	public void setDepartament_id(String departament_id) {
		this.departament_id = departament_id;
	}
	
	
	
	
	
	
	
	
}
