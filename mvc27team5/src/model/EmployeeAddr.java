/*[백지훈]*/
package model;

public class EmployeeAddr {
	private int employeeAddrNo;
	private int employeeNo;
	private String address;
	
	public int getEmployeeAddrNo() {
		return employeeAddrNo;
	}
	public void setEmployeeAddrNo(int employeeAddrNo) {
		this.employeeAddrNo = employeeAddrNo;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeAddr [employeeAddrNo=" + employeeAddrNo + ", employeeNo=" + employeeNo + ", address=" + address
				+ "]";
	}
	
	
	
	
}
