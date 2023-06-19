package com.itplus.test1.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itplus.test1.entity.Employee;
import com.itplus.test1.model.EmployeeModel;
import com.itplus.test1.template.ActionTemplate;
import com.itplus.test1.template.FunctionTemplate;

public class EmployeeController extends FunctionTemplate implements ActionTemplate, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7747892676125616777L;
	
	private EmployeeModel employeeModel;
	
	
	public EmployeeController() {
		employeeModel = new EmployeeModel();
	}

	@Override
	public void handSave(Employee employee) {
		if (isADD) {
			employeeModel.addEmployee(employee);
		}
		if (isEDIT) {
			employeeModel.editEmployee(employee);
		}
	}
	
	public void handDelete(Employee employee) {
		employeeModel.removeEmployee(employee);
	}
	
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}
}
