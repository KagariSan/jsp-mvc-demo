package com.itplus.test1.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.itplus.test1.utils.ConnectionUtil;
import com.itplus.test1.entity.Employee;
import com.itplus.test1.entity.Positition;
import com.itplus.test1.entity.Employee.Gender;
import com.itplus.test1.entity.Employee.Status;

public class EmployeeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2375607011684752854L;

	public List<Employee> getListEmployee() {
		try (Connection conn = ConnectionUtil.getConnection();
				// SQL
				Statement stt = conn.createStatement();
				ResultSet resultSet = stt.executeQuery("SELECT e.*, p.name as `position` FROM test1.employee e left join position p on e.position_id = p.id;;");) {
			List<Employee> result = new ArrayList<Employee>();
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String employeeCode = resultSet.getString("emp_code");
				String name = resultSet.getString("name");
				Date birthDay = resultSet.getDate("birtday");
				String address = resultSet.getString("address");
				String gender = resultSet.getString("gender");
				Long postitionId = resultSet.getLong("position_id");
				String postition = resultSet.getString("position");
				Integer status = resultSet.getInt("status");

				Employee emp = new Employee(id, employeeCode, name, birthDay, address, Gender.valueOf(gender),
						postition, postitionId, Status.values()[status]);
				result.add(emp);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public void addEmployee(Employee employee) {
		try (
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement stt = conn.prepareStatement("INSERT INTO `test1`.`employee` (`emp_code`, `name`, `birtday`, `address`, `gender`, `position_id`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?)");
		) {
			stt.setString(1, employee.getEmpCode());
			stt.setString(2, employee.getName());
			stt.setDate(3, (java.sql.Date) employee.getBirthDay());
			stt.setString(4, employee.getAddress());
			stt.setString(5, employee.getGender().name());
			stt.setLong(6, employee.getPosisitionId());
			stt.setString(7, employee.getStatus().name());
			stt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editEmployee(Employee employee) {
		try (
				Connection conn = ConnectionUtil.getConnection();
				PreparedStatement stt = conn.prepareStatement("UPDATE `test1`.`employee` SET `emp_code` = ?, `name` = ?, `birtday` = ?, `address` = ?, `gender` = ?, `position_id` = ?, `status` = ? WHERE (`id` = ?)");
			) {
				stt.setString(1, employee.getEmpCode());
				stt.setString(2, employee.getName());
				stt.setDate(3, (java.sql.Date) employee.getBirthDay());
				stt.setString(4, employee.getAddress());
				stt.setString(5, employee.getGender().name());
				stt.setLong(6, employee.getPosisitionId());
				stt.setString(7, employee.getStatus().name());
				stt.setLong(8, employee.getId());
				stt.executeUpdate(); // if >= 1 -> success
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void removeEmployee(Employee employee) {
		try (
				Connection conn = ConnectionUtil.getConnection();
				PreparedStatement stt = conn.prepareStatement("DELETE FROM employee e WHERE e.id = ? ");
			) {
				stt.setLong(1, employee.getId());
				int rowAffected = stt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public List<Positition> getListPostition() {
		try (Connection conn = ConnectionUtil.getConnection();
				// SQL
			Statement stt = conn.createStatement();
			ResultSet resultSet = stt.executeQuery("SELECT * FROM position;");) {
			List<Positition> result = new ArrayList<Positition>();
			while (resultSet.next()) {
				Long id = resultSet.getLong(1);
				String name = resultSet.getString("name");
				String status = resultSet.getString("status");

				Positition emp = new Positition(id, name, status);
				result.add(emp);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public boolean isADD = false;
	public boolean isEDIT = false;
	
	public void displayForm() {
		this.isADD = false;
		this.isEDIT = false;
	}
	
	public void changeStateAdd() {
		this.isADD = true;
		this.isEDIT = false;
	}
	
	public void changeStateEdit() {
		this.isEDIT = true;
		this.isADD = false;
	}
	
	public void handCancel() {
		this.isADD = false;
		this.isEDIT = false;
	}
	
	public void handSave(Employee employee) {
		if (isADD) {
			this.addEmployee(employee);
		}
		if (isEDIT) {
			this.editEmployee(employee);
		}
		this.isADD = false;
		this.isEDIT = false;
	}
	
	public void handDelete(Employee employee) {
		this.removeEmployee(employee);
	}
}
