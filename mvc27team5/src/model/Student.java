// [김재희]
package model;

public class Student {
	private int studentNo;
	private String studentId;
	private String studentPw;
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		System.out.println(studentNo + "<--setStudentNo Student.java");
		this.studentNo = studentNo;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		System.out.println(studentId + "<-- setStudentId Student.java");
		this.studentId = studentId;
	}
	public String getStudentPw() {
		return studentPw;
	}
	public void setStudentPw(String studentPw) {
		System.out.println(studentPw + "<-- setStudentPw Student.java");
		this.studentPw = studentPw;
	}
	
	
}
