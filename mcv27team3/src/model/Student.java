//27±â 3ÆÀ ÀÓ°¡Çö 
package model;

public class Student {
	private int studentNo;
	private String studentId;
	private String studentPw;
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int string) {
		this.studentNo = string;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentPw() {
		return studentPw;
	}
	public void setStudentPw(String studentPw) {
		this.studentPw = studentPw;
	}
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studentId=" + studentId + ", studentPw=" + studentPw + "]";
	}
	
}
