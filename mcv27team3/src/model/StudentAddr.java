//27기 3팀 임가현
package model;

public class StudentAddr {
	private int stuedentAddrNo;
	private int StudentNo;
	private String address;
	
	public int getStuedentAddrNo() {
		return stuedentAddrNo;
	}
	public void setStuedentAddrNo(int stuedentAddrNo) {
		this.stuedentAddrNo = stuedentAddrNo;
	}
	public int getStudentNo() {
		return StudentNo;
	}
	public void setStudentNo(int studentNo) {
		StudentNo = studentNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentAddr [stuedentAddrNo=" + stuedentAddrNo + ", StudentNo=" + StudentNo + ", address=" + address
				+ "]";
	}
	
	

}
