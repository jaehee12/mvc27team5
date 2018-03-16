// [김재희]
package model;

public class StudentAddr {
	private int studentAddrNo;
	private int studentNo;
	private String address;
	
	
	public int getStudentAddrNo() {
		return studentAddrNo;
	}
	public void setStudentAddrNo(int studentAddrNo) {
		this.studentAddrNo = studentAddrNo;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentAddr [studentAddrNo=" + studentAddrNo + ", studentNo=" + studentNo + ", address=" + address
				+ "]";
	}
	
	
	
	
	
	
}
