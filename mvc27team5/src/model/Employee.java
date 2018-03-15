/*[백지훈]*/
package model;

public class Employee {
	private int employeeNo;
	private String employeeId;
	private String employeePw;
	private String employeeAddr;
	
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}
	public String getEmployeeAddr() {
		return employeeAddr;
	}
	public void setEmployeeAddr(String employeeAddr) {
		this.employeeAddr = employeeAddr;
	}
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeId=" + employeeId + ", employeePw=" + employeePw
				+ ", employeeAddr=" + employeeAddr + "]";
	}
	
	
}
