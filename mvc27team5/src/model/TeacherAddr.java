package model;

public class TeacherAddr {
	private int teacherAddrNo;
	private int teacherNo;
	private String address;
	public int getTeacherAddrNo() {
		return teacherAddrNo;
	}
	public void setTeacherAddrNo(int teacherAddrNo) {
		this.teacherAddrNo = teacherAddrNo;
	}
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TeacherAddr [teacherAddrNo=" + teacherAddrNo + ", teacherNo=" + teacherNo + ", address=" + address
				+ "]";
	}
	
}
