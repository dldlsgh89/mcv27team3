package model;

public class TeacherAddr {
	private int teacherAddrNo;
	private int teacherNo;
	private int address;
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
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "TeacherAddr [teacherAddrNo=" + teacherAddrNo + ", teacherNo=" + teacherNo + ", address=" + address
				+ "]";
	}
	
	
	
	
}
