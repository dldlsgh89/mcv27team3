//27기 3팀 임가현
package model;

public class StudentAddr {
	private int studentAddrNo;
	private int studentNo;
	private String address;
	
	public int getStudentAddrNo() {
		return studentAddrNo;
	}
	public void setStudentAddrNo(int stuedentAddrNo) {
		this.studentAddrNo = stuedentAddrNo;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		studentNo = studentNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentAddr [stuedentAddrNo=" + studentAddrNo + ", StudentNo=" + studentNo + ", address=" + address
				+ "]";
	}
	
	

}
