package com.itplus.test1.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itplus.test1.entity.Employee;
import com.itplus.test1.entity.Employee.Gender;
import com.itplus.test1.entity.Employee.Status;
import com.itplus.test1.model.EmployeeModel;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		EmployeeModel model = (EmployeeModel) session.getAttribute("model");
		if (model == null) {
			model = new EmployeeModel();
			session.setAttribute("model", model);
		}
		String action = request.getParameter("submit");
		if ("DELETE".equals(action)) {
			Long id = Long.parseLong(request.getParameter("id"));
			Employee emp = new Employee();
			emp.setId(id);
			model.handDelete(emp);
		}
		final RequestDispatcher rd;
		if ("ADD".equals(action)) {
			try {
				String employeeCode = request.getParameter("emp_code");
				String name = request.getParameter("name");
				Date birthDay;
				birthDay = dateFmt.parse(request.getParameter("birtday"));
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				Long postitionId = Long.parseLong(request.getParameter("position_id"));
				Integer status = Integer.parseInt(request.getParameter("status"));
				Employee emp = new Employee(null, employeeCode, name, birthDay, address, Gender.valueOf(gender), null,
						postitionId, Status.values()[status]);
				model.handSave(emp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if ("EDIT".equals(action)) {
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				String employeeCode = request.getParameter("emp_code");
				String name = request.getParameter("name");
				Date birthDay;
				birthDay = dateFmt.parse(request.getParameter("birtday"));
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				Long postitionId = Long.parseLong(request.getParameter("position_id"));
				Integer status = Integer.parseInt(request.getParameter("status"));
				Employee emp = new Employee(id, employeeCode, name, birthDay, address, Gender.valueOf(gender), null,
						postitionId, Status.values()[status]);
				model.handSave(emp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (model.isADD) {
			rd = request.getRequestDispatcher("WEB-INF/add.jsp");
		} else if (model.isEDIT) {
			rd = request.getRequestDispatcher("WEB-INF/edit.jsp");
		} else {
			rd = request.getRequestDispatcher("WEB-INF/list.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
