package model;

public class EmployeeAddr {
	private int employeeAddrNo;
	private int EmployeeNo;
	private String address;
	public int getEmployeeAddrNo() {
		return employeeAddrNo;
	}
	public void setEmployeeAddrNo(int employeeAddrNo) {
		this.employeeAddrNo = employeeAddrNo;
	}
	public int getEmployeeNo() {
		return EmployeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		EmployeeNo = employeeNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeAddr [employeeAddrNo=" + employeeAddrNo + ", EmployeeNo=" + EmployeeNo + ", address=" + address
				+ "]";
	}
}