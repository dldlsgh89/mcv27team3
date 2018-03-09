package Model;

public class Student {
	private int studentNo;
	private String studenId;
	private String studenPw;
	
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudenId() {
		return studenId;
	}
	public void setStudenId(String studenId) {
		this.studenId = studenId;
	}
	public String getStudenPw() {
		return studenPw;
	}
	public void setStudenPw(String studenPw) {
		this.studenPw = studenPw;
	}
	@Override
	public String toString() {
		return "Student [studentNo=" + studentNo + ", studenId=" + studenId + ", studenPw=" + studenPw + "]";
	}
		
	
}
