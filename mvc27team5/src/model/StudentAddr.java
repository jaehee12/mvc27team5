// [김재희]
package model;

public class StudentAddr {
	private int studentAddrNo;
	private int studentNO;
	private String address;
	
	
	public int getStudentAddrNo() {
		return studentAddrNo;
	}
	public void setStudentAddrNo(int studentAddrNo) {
		this.studentAddrNo = studentAddrNo;
	}
	public int getStudentNO() {
		return studentNO;
	}
	public void setStudentNO(int studentNO) {
		this.studentNO = studentNO;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentAddr [studentAddrNo=" + studentAddrNo + ", studentNO=" + studentNO + ", address=" + address
				+ "]";
	}
	
	
	
}
